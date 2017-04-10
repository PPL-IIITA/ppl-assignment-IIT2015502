public class LuxuryGifts {
	int rating;int difficulty;
	double value;double price;
	String giftName;	
	LuxuryGifts(String arr[]) 
        {
		price = Double.parseDouble(arr[3]);
		giftName = arr[4];
                rating = Integer.parseInt(arr[0]);
		difficulty = Integer.parseInt(arr[1]);
		value = 2*(Double.parseDouble(arr[2]));
	}
}
