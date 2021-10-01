echo **************************************************************
echo Generate JAR
echo **************************************************************
mvn clean package -DskipTests
echo **************************************************************
echo BUILD AND PUSH Docker
echo **************************************************************
docker stop ms-seguridad
docker rm  ms-seguridad
echo **************************************************************
docker  build -t dancourbano/ms-seguridad .
docker push  dancourbano/ms-seguridad
echo **************************************************************
echo run image 
docker run -p 8010:8010 --name ms-seguridad --network pragma-project -d dancourbano/ms-seguridad
echo *************************************************************
echo End Process
echo *************************************************************