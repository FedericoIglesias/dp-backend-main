# Usar la imagen oficial de MySQL como base
FROM mysql:latest

# Establecer las variables de entorno necesarias
ENV MYSQL_ROOT_PASSWORD admin
ENV MYSQL_DATABASE dhm
ENV MYSQL_USER admin
ENV MYSQL_PASSWORD admin


# Copiar los scripts de inicialización a la ubicación correcta en el contenedor
COPY ./mysql-init /docker-entrypoint-initdb.d

# Definir un volumen para los datos de MySQL
VOLUME /var/lib/mysql

# Exponer el puerto de MySQL
EXPOSE 3306