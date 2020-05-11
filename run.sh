javac -d ./bin . $(find ./src -name "*.java")
jar cvfm  PokerHanderGame.jar  Manifest.txt  $(find ./bin  -name "*.class") .
java -jar PokerHanderGame.jar