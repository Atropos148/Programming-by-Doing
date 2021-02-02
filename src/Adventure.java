import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Adventure {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        HashMap<String, Room> allRooms = roomSetup();

        Room currentRoom = allRooms.get("entrance");

        // there are 4 layers of Rooms, last one is endings
        int roomIndex = 0;
        while (roomIndex < 3) {
            currentRoom.printDescription();
            currentRoom = allRooms.get(currentRoom.handleResponse(keyboard));
            roomIndex++;
        }
        currentRoom.printDescription();
        System.out.println("The End");

    }

    static HashMap<String, Room> roomSetup() {
        HashMap<String, Room> allRooms = new HashMap<>();
        // Room Setup
        // layer 1
        // entrance
        String[] connectedRoomsEntrance = { "upstairs", "kitchen" };
        Room entrance = new Room("entrance",
                "You are in a creepy house! Would you like to to go \"upstairs\" or into the \"kitchen\"?",
                connectedRoomsEntrance);

        // layer 2
        // kitchen
        String[] connectedRoomsKitchen = { "fridge", "cabinet" };
        Room kitchen = new Room("kitchen",
                "There is a long countertop with dirty dishes everywhere.  Off to one side there is, as you'd expect, a refrigerator. You may open the \"fridge\" or look in a \"cabinet\".",
                connectedRoomsKitchen);
        // upstairs
        String[] connectedRoomsUpstairs = { "bedroom", "bathroom" };
        Room upstairs = new Room("upstairs",
                "Upstairs you see a hallway.  At the end of the hallway is the master \"bedroom\". There is also a \"bathroom\" off the hallway.  Where would you like to go?",
                connectedRoomsUpstairs);

        // layer 3
        // fridge
        String[] connectedRoomsFridge = { "eat", "leave" };
        Room fridge = new Room("fridge",
                "Inside the refrigerator you see food and stuff.  It looks pretty good. Would you like to \"eat\" some of the food? Or \"leave\" it alone?",
                connectedRoomsFridge);
        // cabinet
        String[] connectedRoomsCabinet = { "snacks", "pills" };
        Room cabinet = new Room("cabinet",
                "When you open the cabinet you notice there are some healthy \"snacks\" and some \"pills\" you don't reconize. Which do you want to eat?",
                connectedRoomsCabinet);
        // bedroom
        String[] connectedRoomsBedroom = { "nap", "clothes" };
        Room bedroom = new Room("bedroom",
                "You are in a plush bedroom, with expensive-looking hardwood furniture.  The bed is unmade.  In the back of the room, the closet door is ajar. You can take a \"nap\", or try out some \"clothes\" from the closet.",
                connectedRoomsBedroom);
        // bathroom
        String[] connectedRoomsBathroom = { "mirror", "teeth" };
        Room bathroom = new Room("bathroom",
                "This bathroom is smaller than the one you have at your apartment. You can brush your \"teeth\" or just check your hair in the  \"mirror\".",
                connectedRoomsBathroom);

        // layer 4 - endings
        // eat
        Room eat = new Room("eat",
                "You take some of the food. As you sit down to eat it, you feel a cold draft of air on your neck. 'Eat as much as you want', says the ghost lady 'I prepared enough for my whole family!'.",
                new String[0]);
        // leave
        Room leave = new Room("leave",
                "When you decide to leave the food alone you suddenly feel a cold draft of air on your neck. 'Please eat something', says the ghost lady 'I prepared enough for my whole family!'.",
                new String[0]);
        // snacks
        Room snacks = new Room("snacks",
                "As you are tasting all the different snacks you suddenly feel a cold draft of air on your neck. 'Delicius and nutritious', says the ghost lady 'That's why all of us enjoyed them!'.",
                new String[0]);
        // pills
        Room pills = new Room("pills",
                "'Lucky for you, those are only sleeping pills.', says the ghost lady when you put a few of the pills in your mouth. 'Remember, never take pills you don't recognize!'.",
                new String[0]);
        // nap
        Room nap = new Room("nap",
                "Seeing the bad is already prepared, you lay down to take a nap. The ghost lady wishes you a good sleep. About an hour later, you wake up refreshed.",
                new String[0]);
        // clothes
        Room clothes = new Room("clothes",
                "'You are the same size as me! Try anything you want!', says the ghost lady as you start looking thru the clothes. You find some nice pieces of fashion and take them home.",
                new String[0]);
        // mirror
        Room mirror = new Room("mirror",
                "'I really like the color of your hair? Did you do it yourself?', asks the ghost lady as you look into the mirror. You swap some tips and tricks on #hairCare.",
                new String[0]);
        // teeth
        Room teeth = new Room("teeth",
                "'Don't forget to floss as well!', suggests the ghost lady as you are brushing your teeth. She is impressed with you efficient flossing thechnique when you show her how you do it.",
                new String[0]);

        allRooms.put(entrance.name, entrance);

        allRooms.put(kitchen.name, kitchen);
        allRooms.put(upstairs.name, upstairs);

        allRooms.put(fridge.name, fridge);
        allRooms.put(cabinet.name, cabinet);
        allRooms.put(bedroom.name, bedroom);
        allRooms.put(bathroom.name, bathroom);

        allRooms.put(eat.name, eat);
        allRooms.put(leave.name, leave);
        allRooms.put(snacks.name, snacks);
        allRooms.put(pills.name, pills);
        allRooms.put(nap.name, nap);
        allRooms.put(clothes.name, clothes);
        allRooms.put(mirror.name, mirror);
        allRooms.put(teeth.name, teeth);

        return allRooms;
    }
}

class Room {
    String name;
    String description;
    String[] choicesText;
    String[] connectedRooms;

    Room(String name, String description, String[] connectedRooms) {
        this.name = name;
        this.description = description;
        this.connectedRooms = connectedRooms;
    }

    void printDescription() {
        System.out.println(description);
    }

    String handleResponse(Scanner keyboard) {
        while (true) {
            try {
                System.out.print("Where do you want to go? > ");
                String newRoom = keyboard.nextLine();
                if (checkAnswer(newRoom)) {
                    return newRoom;
                } else {
                    System.out.println("That is not a possible choice.");
                }
            } catch (InputMismatchException e) {
                keyboard.next();
                System.out.println("Only use words to answer.");
            }
        }

    }

    boolean checkAnswer(String answer) {
        return Arrays.asList(connectedRooms).contains(answer);
    }
}