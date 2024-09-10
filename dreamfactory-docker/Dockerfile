FROM dreamfactorysoftware/df-base-img:ubuntu-20

# Configure Nginx
COPY dreamfactory.conf /etc/nginx/sites-available/dreamfactory.conf


RUN apt-get update && apt-get install -y software-properties-common \
    && add-apt-repository ppa:ondrej/php \
    && apt-get update \
    && apt-get install -y --no-install-recommends php8.1 \
    php8.1-fpm php8.1-cli php8.1-mbstring php8.1-xml php8.1-mysql php8.1-zip \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# Get DreamFactory
RUN git clone https://github.com/dreamfactorysoftware/dreamfactory.git /opt/dreamfactory

WORKDIR /opt/dreamfactory
RUN ls -lrt
# Uncomment lines 12 & 21 if you would like to upgrade your environment while replacing the License Key value with your issued Key and adding the license files to the df-docker directory.
# COPY composer.* /opt/dreamfactory/
RUN php -v
# Install packages
RUN composer install --no-dev --ignore-platform-reqs

RUN php artisan df:env --db_connection=sqlite --df_install=Docker 
RUN chown -R www-data:www-data /opt/dreamfactory
RUN rm /etc/nginx/sites-enabled/default

COPY docker-entrypoint.sh /docker-entrypoint.sh

# RUN sed -i "s,\#DF_REGISTER_CONTACT=,DF_LICENSE_KEY=YOUR_LICENSE_KEY," /opt/dreamfactory/.env

# Set proper permission to docker-entrypoint.sh script and forward error logs to docker log collector
RUN chmod +x /docker-entrypoint.sh && ln -sf /dev/stderr /var/log/nginx/error.log && rm -rf /var/lib/apt/lists/*

# Clean up
RUN apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

EXPOSE 80

CMD ["/docker-entrypoint.sh"]
