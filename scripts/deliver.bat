@echo OFF
set ARTIFACT=superPoker.war
set DESTDIR=C:\Users\Matthias\Documents\Java\Jenkins\Servers\apache-tomcat-9.0.24\webapps
copy target\%ARTIFACT% %DESTDIR%