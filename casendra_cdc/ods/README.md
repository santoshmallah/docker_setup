<Configuration>
<Properties>
<Property name="basePath">logs/</Property>
<Property name="layout">%d [%t] %-5level %logger{36} - %m%n</Property>
</Properties>
<Appenders>
<Console name="Console">
<PatternLayout pattern="${layout}"/>
</Console>
-->
<!--  File Appender  -->
<RollingFile name="RollingFile" fileName="${basePath}ENTITYLOG.log" filePattern="${basePath}ENTITYLOG-%d{MM-dd-yyyy}-%i.log">
<PatternLayout pattern="%d | %5p | [%t] | %c:%M(%L) | %m %n"/>
<Policies>
<TimeBasedTriggeringPolicy interval="1" modulate="true"/>
<!-- Every day start creating new file from midnight   -->
<SizeBasedTriggeringPolicy size="10 MB"/>
<!--  The size of the file before rollover is required.  -->
</Policies>
<DefaultRolloverStrategy max="2"/>
</RollingFile>
</Appenders>
<Loggers>
<Logger name="com.klayx.entity" level="FATAL" additivity="false">
<AppenderRef ref="RollingFile"/>
</Logger>
<Root level="FATAL">
<AppenderRef ref="RollingFile"/>
<AppenderRef ref="Console"/>
</Root>
</Loggers>
</Configuration>
