package bikePickUp.Bike;

public class PickUpClass implements PickUp{

    private String idBike,idUser,initialParkID,finalParkID;
    private int minutes,cost;
    
    public PickUpClass(String idBike,String idUser,String initialParkID){
    	this.idBike = idBike;
    	this.idUser = idUser;
    	this.initialParkID = initialParkID;
    }

	@Override
	public String getBikeID() {
		return idBike;
	}

	@Override
	public String getUserID() {
		return idUser;
	}

    @Override
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public int getMinutes() {
        return minutes;
    }

    @Override
    public void setFinalParkID(String finalParkID) {
        this.finalParkID = finalParkID;
    }

    @Override
    public String getFinalParkID() {
        return finalParkID;
    }

    @Override
    public int minutesLate() {
        return minutes - MAX_MINS;
    }
}