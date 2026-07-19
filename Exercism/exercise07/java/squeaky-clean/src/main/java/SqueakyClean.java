class SqueakyClean {
    static String clean(String identifier) {
        char[] charArray = identifier.toCharArray();
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < charArray.length; i++){
            char character = charArray[i];
            if(character == ' '){
                result.append("_");
            }else if(character == '-' && i + 1 < charArray.length){
                result.append(Character.toUpperCase(charArray[i + 1]));
                i++;
            }else if(Character.isDigit(character)){
                switch (character){
                    case '4':
                        result.append('a');
                        break;
                    case '3':
                        result.append('e');
                        break;
                    case '0':
                        result.append('o');
                        break;
                    case '1':
                        result.append('l');
                        break;
                    case '7':
                        result.append('t');
                        break;
                }
            }else if(Character.isLetter(character)){
                result.append(character);
            }
        }
        return result.toString();
    }
}
