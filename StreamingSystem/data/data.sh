#!/bin/bash

# Nos colocamos en el directorio adecuado
cd './StreamingSystem/data'

# Descargamos el fichero de tráfico
wget 'https://datos.madrid.es/egob/catalogo/202087-0-trafico-intensidad.xml' -O 'ficheroTrafico.xml'
echo "Fichero tráfico descargado exitosamente"

# Descargamos el fichero de gasolina
curl -o 'ficheroGasolina.xls' 'https://geoportalgasolineras.es/resources/files/preciosEESS_es.xls'
echo "Fichero gasolina descargado exitosamente"
