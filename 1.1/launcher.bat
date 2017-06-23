@echo off
cd "out/artifacts/InfinityWayTwo_jar/"
:loop
	java -jar InfinityWayTwo.jar
	pause
	cls
	goto :loop