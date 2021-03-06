package BikePickUp.User;

import BikePickUp.PickUp.PickUp;
import BikePickUp.PickUp.PickUpSet;
import dataStructures.DoublyLinkedList;
import dataStructures.Iterator;
import dataStructures.List;

/**
 * @author Goncalo Areia (52714) g.areia@campus.fct.unl.pt
 * @author Tiago Guerreiro (53649) tf.guerreiro@campus.fct.unl.pt
 */
public class UserClass implements UserSet {

    /**
     * Constant for serialization
     */
	private static final long serialVersionUID = 0L;

    /**
     * User's NIF, User's name, User's address, User's email, User's phone number.
     */
	private String NIF;
    private String name;
    private String address;
    private String email;
    private String phone;

    /**
     * User balance and points.
     */
    private int balance,points;

    /**
     *  List of all pickups where the user was involved.
     */
    private List<PickUp> pickUps;

    /**
     * Unfinished pickup that is being executed.
     */
    private PickUpSet currentPickUp;


    /**
     *  @param NIF User NIF
     * @param email User email
     * @param phone User phone number
     * @param name User name
     * @param address User address
     */
    public UserClass(String NIF, String email, String phone, String name, String address) {
        this.NIF = NIF;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.balance = INITIAL_BALANCE;
        this.points = INITIAL_POINTS;
        this.pickUps = new DoublyLinkedList<>();
        this.currentPickUp = null;
    }


    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public void pickUp(PickUpSet pickUp) {
        currentPickUp = pickUp;
    }

    @Override
    public boolean hasUsedSystem() {
        return !pickUps.isEmpty() || currentPickUp != null;
    }

    @Override
    public void pickDown(String finalParkID, int minutes) {
        currentPickUp.setFinalParkID(finalParkID);
        currentPickUp.setMinutes(minutes);
        currentPickUp.setCost();
        if(currentPickUp.getCost() > 0)
        	points++;
        balance-= currentPickUp.getCost();
        pickUps.addLast(currentPickUp);
        currentPickUp = null;
    }

    @Override
    public void charge(int value) {
        balance += value;
    }

	@Override
	public boolean isUserIsOnFirstPickUp() {
		return pickUps.isEmpty() &&  currentPickUp != null ;
	}

	@Override
	public Iterator<PickUp> getUserPickUps() {
		return pickUps.iterator();
	}

	@Override
	public int getPoints() {
		return points;
	}

    @Override
    public boolean isOnTheMove() {
        return currentPickUp != null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getNIF() {
        return NIF;
    }
}
