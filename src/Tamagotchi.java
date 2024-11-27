public class Tamagotchi {
    // Attributes to store the Tamagotchi's name, hunger, happiness, health, and life status.
    private String petName;
    private int hunger;
    private int happiness;
    private int health;
    private boolean isAlive;

    // Constructor initializes the Tamagotchi with a name and default attributes.
    public Tamagotchi(String name) {
        petName = name;
        hunger = 50; // Initial hunger level (scale: 0 to 100).
        happiness = 50; // Initial happiness level (scale: 0 to 100).
        health = 100; // Initial health level (scale: 0 to 100).
        isAlive = true; // Tamagotchi starts alive.
    }

    // Method to feed the Tamagotchi, reducing hunger and increasing health.
    public void feed() {
        if (isAlive && hunger > 0) {
            int foodEffect = (int) (Math.random() * 15 + 5); // Random hunger reduction between 5 and 15.
            hunger = Math.max(hunger - foodEffect, 0); // Ensure hunger doesn't go below 0.
            health = Math.min(health + 5, 100); // Increase health slightly, up to the max of 100.
            System.out.println(petName + " has been fed! Hunger reduced by " + foodEffect + ". Current Hunger: " + hunger + ".");
        } else if (!isAlive) {
            System.out.println(petName + " DIED and can't be fed.");
        } else {
            System.out.println(petName + " is not hungry!");
        }
    }

    // Method to play with the Tamagotchi, increasing happiness but potentially impacting hunger and health.
    public void play() {
        if (isAlive) {
            int funEffect = (int) (Math.random() * 10 + 5); // Random happiness boost between 5 and 10.
            happiness = Math.min(happiness + funEffect, 100); // Cap happiness at 100.
            hunger = Math.min(hunger + 5, 100); // Slight increase in hunger due to activity.
            if (hunger > 80 || health < 50) { // Health penalty if hunger is high or health is low.
                health = Math.max(health - 10, 0); // Decrease health, ensuring it doesn't go below 0.
            }
            System.out.println(petName + " played and had fun! Happiness increased by " + funEffect + ". Current Happiness: " + happiness + ".");
        } else {
            System.out.println(petName + " DIED and can't play.");
        }
    }

    // Method to display the Tamagotchi's current status.
    public void checkStatus() {
        System.out.println("Name: " + petName);
        System.out.println("Hunger: " + hunger);
        System.out.println("Happiness: " + happiness);
        System.out.println("Health: " + health);
        System.out.println("Alive: " + (isAlive ? "Yes" : "No"));

        if (health <= 0 || hunger >= 100) { // Update isAlive status based on health and hunger levels.
            isAlive = false;
            System.out.println(petName + " has died due to poor health or extreme hunger...");
        }
    }

    // Method to trigger a random event that affects the Tamagotchi's attributes.
    public void randomEvent() {
        if (isAlive) {
            int event = (int) (Math.random() * 3); // Randomly select one of three events.
            if (event == 0) {
                System.out.println("A rare treat was found! Hunger reduced slightly.");
                hunger = Math.max(hunger - 10, 0);
            } else if (event == 1) {
                System.out.println("A surprise rainstorm made " + petName + " sick. Health decreased.");
                health = Math.max(health - 15, 0);
            } else {
                System.out.println(petName + " found a treasure chest! Happiness increased.");
                happiness = Math.min(happiness + 20, 100);
            }
        } else {
            System.out.println(petName + " is no longer alive and can't experience events.");
        }
    }
}
