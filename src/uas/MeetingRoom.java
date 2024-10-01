package uas;

public class MeetingRoom implements Borrowable{
	private boolean availability;
	private int capacity;
	private String roomName;
	public MeetingRoom(int capacity, String roomName) {
		availability = true;
		this.capacity = capacity;
		this.roomName = roomName;
	}
	public boolean isAvailability() {
		return availability;
	}
	public int getCapacity() {
		return capacity;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public void borrowItem() {
		availability = false;
	}
	
	public void returnItem() {
		availability = true;
	}
	public String toString() {
        return "Room name: " + roomName + "\nCapacity: " + capacity + "\nAvailability: " + availability;
    }
}
