package com.sql.smartpra.ods.datatrans.ods_datatrans.repositorys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.sql.smartpra.ods.datatrans.ods_datatrans.entity.MasOdsConfigParameter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Repository
public class NewMongoRepo {

	@Autowired
	private OdsRepository odsRepository;

	private MongoTemplate mongoTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void MongoRepository(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Transactional
	public List<Document> findJsonData() {

		List<MasOdsConfigParameter> masOdsConfigParameters = odsRepository.findAll();

		if (masOdsConfigParameters != null && !masOdsConfigParameters.isEmpty()) {

			List<String> jsonDBNodes = masOdsConfigParameters.stream().map(MasOdsConfigParameter::getJson_node)
					.distinct().collect(Collectors.toList());

			Multimap<String, MasOdsConfigParameter> multiMap = ArrayListMultimap.create();
			masOdsConfigParameters.stream().forEach(dbRow -> {
				multiMap.put(dbRow.getJson_node(), dbRow);
			});

			var documents = mongoTemplate.findAll(Document.class, "ticket_mainDTO");
			Multimap<String, KeyValue> tableDataMap = ArrayListMultimap.create();

			documents.forEach(document -> {
				for (String nodeName : jsonDBNodes) {
					var dbRows = multiMap.asMap().get(nodeName);
					if (nodeName.equals("root")) {
						for (MasOdsConfigParameter dbRow : dbRows) {
							var jsonValue = document.get(dbRow.getJson_property());

							if (jsonValue instanceof List) {

							} else {
								tableDataMap.put(dbRow.getTable_name(),
										new KeyValue(dbRow.getColumn_name(), jsonValue));
							}
						}
					} else {
						var jsonNodes = document.getList(nodeName, Document.class);
						if (jsonNodes != null) {
							int i = 0;
							for (Document jsonNode : jsonNodes) {
								for (MasOdsConfigParameter row : dbRows) {
									tableDataMap.put(row.getTable_name() + "~" + i,
											new KeyValue(row.getColumn_name(), jsonNode.get(row.getJson_property())));
								}
								i++;
							}
						}
					}
				}

				tableDataMap.asMap().forEach((tableName, keyValueList1) -> {
					String joinedKeys = keyValueList1.stream().map(KeyValue::getKey).collect(Collectors.joining(", "));

					StringBuffer sb = new StringBuffer("");
					for (KeyValue o : keyValueList1) {
						if (sb.length() > 1)
							sb.append(",");
						if (o.getValue() instanceof String) {
							sb.append("'" + o.getValue() + "'");
						} else {
							sb.append(o.getValue());
						}
					}

					String insertQuery = "INSERT INTO " + tableName.split("~")[0] + " (" + joinedKeys + ") VALUES ("
							+ sb.toString() + ")";

					System.out.println("INSERTION QUERY FOR " + tableName + ": " + insertQuery);

				}
				);
			});
		}

		return new ArrayList<>();
	}

	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	class KeyValue {
		String key;
		Object value;

	}

}
