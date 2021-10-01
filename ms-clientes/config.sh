echo **************************************************************
echo Generate JAR
echo **************************************************************
mvn clean package -DskipTests
echo **************************************************************
echo BUILD AND PUSH Docker
echo **************************************************************
docker stop ms-clientes
docker rm  ms-clientes
echo **************************************************************
docker  build -t dancourbano/ms-clientes .
docker push  dancourbano/ms-clientes
echo **************************************************************
echo run image 
docker run -p 8083:8083 --name ms-clientes --network pragma-project -d dancourbano/ms-clientes
echo *************************************************************
echo End Process
echo *************************************************************