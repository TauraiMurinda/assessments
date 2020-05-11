javac -d .  $(find ./src -name "*.java")
jar -cvfm  PokerHanderGame.jar  Manifest.txt  $(find .  -name "*.class") .
java -jar PokerHanderGame.jar