package BikePickUp.Bike;

import BikePickUp.PickUp.PickUp;
import BikePickUp.PickUp.PickUpSet;
import dataStructures.DoublyLinkedList;
import dataStructures.Iterator;
import dataStructures.List;

/**
 * @author Goncalo Areia (52714) g.areia@campus.fct.unl.pt
 * @author Tiago Guerreiro (53649) tf.guerreiro@campus.fct.unl.pt
 */
public class BikeClass implements BikeSet {

    /**
     * Constant for serialization
     */
	private static final long serialVersionUID = 0L;

    /**
     * Bike's identification, park's identification and the bike's license.
     */
	private String bikeID, parkID,bikeLicense;

    /**
     * List of all the pickups that the bike was involved.
     */
    private List<PickUp> pickUps;

    /**
     * Unfinished pickup that is being executed.
     */
    private PickUpSet currentPickUp;

    /**
     *
     * @param bikeID Bike identification.
     * @param parkID Park identification.
     * @param bikeLicense Bike's license.
     */
    public BikeClass(String bikeID, String parkID, String bikeLicense) {
        this.bikeID = bikeID;
        this.parkID = parkID;
        this.bikeLicense = bikeLicense;
        this.pickUps = new DoublyLinkedList<>();
        this.currentPickUp = null;
    }

	@Override
	public String getID() {
		return bikeID;
	}

    @Override
    public void pickUp(PickUpSet pickUp) {
        currentPickUp = pickUp;
    }

    @Override
    public boolean hasBeenUsed() {
        return !pickUps.isEmpty() || currentPickUp != null ;
    }

    @Override
    public String getParkID() {
        return parkID;
    }

    @Override
    public void pickDown(String finalParkID, int minutes) {
        currentPickUp.setFinalParkID(finalParkID);
        currentPickUp.setMinutes(minutes);
        currentPickUp.setCost();
        pickUps.addLast(currentPickUp);
        currentPickUp = null;
    }

	@Override
	public boolean isBikeOnFirstPickUp() {
		return pickUps.isEmpty() && currentPickUp != null;
	}

	@Override
	public Iterator<PickUp> getBikePickUps() {
		return pickUps.iterator();
	}

	@Override
	public String getBikeLicense() {
		return bikeLicense;
	}

    @Override
    public boolean isOnTheMove() {
        return  currentPickUp != null;
    }

    @Override
    public String getUserID() {
        return currentPickUp.getUserID();
    }
}
