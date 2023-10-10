package com.techelevator.dogrescue;

public class Dog {

        //Class variables - static
        public static final String ANCESTOR = "Wolf";
        public static int dogCount;


        // Instance variables - properties/ attributes/ - (Step 1 - Encapsulation - private access modifiers)
        private String name;
        private int age;
        private String breed = "unknown"; //default value
        private String owner;
        private String microChipId;

        //constructor
        public Dog(){
            dogCount++;
        }

        public Dog (String name, int age, String breed){
            this.name = name;
            this.age = age;
            this.breed = breed;

            dogCount++;
        }


        //Getters and Setters - (Step 2 - Encapsulation - public getters and setters)
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }

        public int getAge(){
            return age;
        }

        public void setAge(int age){
            if(age < 1) {
                this.age = 1;
            }else{
                this.age = age;
            }
        }

        //read only
        public String getBreed(){
            return breed;
        }

        public String getOwner(){
            return owner;
        }

        public void setOwner(String owner){
            this.owner = owner;

        }

        public String getMicroChipId(){
            return microChipId;
        }

        public void setMicroChipId(String microChipId){
            this.microChipId = microChipId;
        }

        public int getAgeInDogYears(){
            int ageDogYears = age * 7;
            return ageDogYears;
        }


        // Custom method
        public String bark(){
            String barkMsg = name + " says woof...woof!";
            System.out.println("I see the Amazon delivery person!");
            return barkMsg;
        }

        public String bark(String dogName){
            String barkMsg = name + " says woof...woof!";
            System.out.println(dogName + " sees the Amazon delivery person!");
            return barkMsg;
        }

        public String bark(String dogName, int age){
            String barkMsg = name + " says woof...woof!";
            System.out.println(dogName + " sees the Amazon delivery person!");
            return barkMsg;
        }








}
