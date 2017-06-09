cp PlanterServer-1.0-SNAPSHOT.war server_projects/Planter
sudo cp PlanterServer-1.0-SNAPSHOT.war /opt/tomcat7/apache-tomcat-7.0.77/webapps
cd server_projects/Planter
jar -xvf PlanterServer-1.0-SNAPSHOT.war
rm PlanterServer-1.0-SNAPSHOT.war
cd ..
sudo cp -r Planter /opt/tomcat7/apache-tomcat-7.0.77/webapps
cd /opt/tomcat7/apache-tomcat-7.0.77/webapps
sudo mv PlanterServer-1.0-SNAPSHOT.war Planter.war
