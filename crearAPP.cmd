@echo off

if "%1"=="" goto ERROR

echo Creando estructura de APP: %1

mvn archetype:generate -DarchetypeGroupId=com.logirail -DarchetypeArtifactId=app-web-archetype -DarchetypeVersion=1.0 -DgroupId=com.logirail -DartifactId=%1 -Dversion=1.0
goto FIN

:ERROR
echo Falta el parámetro con el nombre de la aplicación. P.ej.: %~n0 app1

:FIN
