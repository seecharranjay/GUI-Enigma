public class Rotor {

    
    private String rotorValues;
    private char startChar;
    private int pos; //creating a new int to represent the position of the rotor
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    
    public boolean rotate(){
        //TODO

        //find the last value to move to the front
        char last = rotorValues.charAt(rotorValues.length() - 1);
        //make a string the represents the rest of the characters before the last one
        String rest = rotorValues.substring (0, rotorValues.length() - 1);
        //add the rest of the characters to the last character, so the last character is now in front
        rotorValues = last + rest;

        //return statements
        if (rotorValues.charAt(0) == startChar) {
            return true;
        }
        else {
            return false;
        }


               
    }
    

    public int indexOf(char c){
        //TODO
        //have to retrun index of the string

        //assigning an int to the String
        int index = rotorValues.indexOf(c);

        return index;

    }

    public char charAt(int idx){
        //TODO
        //have to return the char at the index given

        //assiging an in to be the index of the char
        int index = (idx + pos) % rotorValues.length();
        //adding idx and pos to get the position of the character
        // bc it shifts the index by the amt of positions the rotor rotated

        return rotorValues.charAt(index);

    }

}
    
