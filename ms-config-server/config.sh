echo **************************************************************
echo Generate JAR
echo **************************************************************
mvn clean package -DskipTests
echo **************************************************************
echo BUILD AND PUSH Docker
echo **************************************************************
docker stop ms-config-server
docker rm  ms-config-server
echo **************************************************************
docker  build -t dancourbano/ms-config-server .
docker push  dancourbano/ms-config-server
echo **************************************************************
echo run image 
docker run -p 8888:8888 --name msconfigserver --network pragma-project -d dancourbano/ms-config-server
echo *************************************************************
echo End Process
echo *************************************************************