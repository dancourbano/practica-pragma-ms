echo **************************************************************
echo Generate JAR
echo **************************************************************
mvn clean package -DskipTests
echo **************************************************************
echo BUILD AND PUSH Docker
echo **************************************************************
docker stop ms-fotos
docker rm  ms-fotos
echo **************************************************************
docker  build -t dancourbano/ms-fotos .
docker push  dancourbano/ms-fotos
echo **************************************************************
echo run image 
docker run -p 8084:8084 --name ms-fotos --network pragma-project -d dancourbano/ms-fotos
echo *************************************************************
echo End Process
echo *************************************************************