public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0)); //inner
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));//middle
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2)); //outer
        
    }


    public String decrypt(String message){        
        //TODO
        //have to create the message by going through each rotor
        
        String decryptMessage = "";

        for (int i = 0; i < message.length(); i++) {
            char curr = message.charAt(i);
            //find index of outer char
            int outerInd = rotors[2].indexOf(curr);
            //at outer index find middle char
            char middleChar = rotors[1].charAt(outerInd);
            //find index of middle char on outer
            int outerInd2 = rotors[2].indexOf(middleChar);
            //get inner char at outer index
            char decryptChar = rotors[0].charAt(outerInd2);

            //add decrypted char to the message
            decryptMessage += decryptChar;

            //rotate
            rotate();


        }
        return decryptMessage;
        

    }


    
    public String encrypt(String message){
        //TODO
        //intialize the encrypted message
        String encryptMessage = "";

        //inner -> outer char = middle char -> outer
        for (int i = 0; i < message.length(); i++) {
            //assign char chat to the first char of message
            char curr = message.charAt(i);
            // integer for the index of inner with curr
            int innerInd = rotors[0].indexOf(curr); 
            //get charcter of outer at the same index of inner
            char outerChar = rotors[2].charAt(innerInd);
            //get the index of the middle char that matches the outer charcter
            int middleInd = rotors[1].indexOf(outerChar);
            //get the encrypted char that's the outer charcter on the middle index
            char encryptChar = rotors[2].charAt(middleInd);

            //adding the encrypted character to the message
            encryptMessage += encryptChar;
            
            //then rotate
            rotate();
        }
        return encryptMessage;
    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
