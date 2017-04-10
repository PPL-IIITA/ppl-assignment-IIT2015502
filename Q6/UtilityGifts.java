public class UtilityGifts 
{
	int uvalue;int uclass;
	double value;double price;String giftName;
	UtilityGifts(String arr[])
        {
		price = Double.parseDouble(arr[3]);	
		uvalue = Integer.parseInt(arr[0]);
		uclass = Integer.parseInt(arr[1]);
		value = Double.parseDouble(arr[2]);
                giftName = arr[4];
	}
}
