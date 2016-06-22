import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;



public class Main {

	public static void main(String[] args)
	{
		testA();
		testB();
		testC();
	}


	private static void testA()
	{
		Point[] points = {
				new Point(0, 0),
				new Point(3, 1),
				new Point(2, 3),
				new Point(1, 2),
				new Point(4, 4),
		};

		PDT pdt=new PointDataStructure(points,points[3]);
		String testName;
		int expected;
		int result;

		testName = "A0";
		testExpectedPoints(testName, points, pdt.getAllPoints());

		int XLeft=3;
		int XRight=7;
		testName = "A1";
		expected = 2;
		result = pdt.numOfPointsInRange(XLeft, XRight);
		testExpected(testName, expected, result);

		XLeft=1;
		XRight=3;
		testName = "A2";
		double expectedD = 2.0;
		double resultD = pdt.averageHeightInRange(XLeft, XRight);
		testExpected(testName, expectedD, resultD);

		testName = "A3.1";
		Point[] expectedPoints1 = {
				new Point(1, 2),
		};
		testExpectedPoints(testName, expectedPoints1, pdt.getMedianPoints(1));
		testName = "A3.2";
		Point[] expectedPoints2 = {
				new Point(3, 1),
				new Point(1, 2),
		};
		testExpectedPoints(testName, expectedPoints2, pdt.getMedianPoints(2));
		testName = "A3.3";
		Point[] expectedPoints3 = {
				new Point(3, 1),
				new Point(2, 3),
				new Point(1, 2),
		};
		testExpectedPoints(testName, expectedPoints3, pdt.getMedianPoints(3));

		Point[] points2 = {
				new Point(1, 4),
				new Point(2, 7),
				new Point(3, 15),
				new Point(7, 7),
				new Point(8, 2),
				new Point(9, 9),
				new Point(12, 5),
				new Point(13, 7),
				new Point(15, 15),
				new Point(35, 12),
		};

		pdt=new PointDataStructure(points2,points2[7]);


		testName = "A4";
		XLeft=12;
		XRight=100;
		Point[] expectedLargePoints = {
				new Point(12, 5),
				new Point(13, 7),
				new Point(15, 15),
				new Point(35, 12),
		};
		testExpectedPoints(testName, expectedLargePoints, pdt.getPointsInRange(XLeft, XRight));

		XLeft=3;
		XRight=7;
		testName = "A5";
		expected = 2;
		result = pdt.numOfPointsInRange(XLeft, XRight);
		testExpected(testName, expected, result);

		XLeft=7;
		XRight=9;
		testName = "A6";
		expectedD = 6.0;
		resultD = pdt.averageHeightInRange(XLeft, XRight);
		testExpected(testName, expectedD, resultD);

		testName = "A7.1";
		Point[] expectedPoints4 = {
				new Point(13, 7),
		};
		testExpectedPoints(testName, expectedPoints4, pdt.getMedianPoints(1));
		testName = "A7.2";
		Point[] expectedPoints5 = {
				new Point(7, 7),
				new Point(13, 7),
		};
		testExpectedPoints(testName, expectedPoints5, pdt.getMedianPoints(2));
		testName = "A7.3";
		Point[] expectedPoints6 = {
				new Point(7, 7),
				new Point(13, 7),
				new Point(9, 9),
		};
		testExpectedPoints(testName, expectedPoints6, pdt.getMedianPoints(3));
		testName = "A7.4";
		Point[] expectedPoints7 = {
				new Point(2, 7),
				new Point(7, 7),
				new Point(13, 7),
				new Point(9, 9),
		};
		testExpectedPoints(testName, expectedPoints7, pdt.getMedianPoints(4));
		testName = "A7.5";
		Point[] expectedPoints8 = {
				new Point(2, 7),
				new Point(7, 7),
				new Point(13, 7),
				new Point(9, 9),
				new Point(35, 12),
		};
		testExpectedPoints(testName, expectedPoints8, pdt.getMedianPoints(5));

	}





	private static void testB()
	{

		final int NUM = 100;

		Point[] points = new Point[NUM];

		for (int i=0; i<NUM; ++i)
		{
			points[i] = new Point(NUM-i-1, i);
		}

		PDT pdt=new PointDataStructure(points,points[NUM/2]);

		String testName;
		int expected;
		int result;

		testName = "B0";
		testExpectedPoints(testName, points, pdt.getAllPoints());

		int XLeft=3;
		int XRight=7;
		testName = "B1";
		expected = 5;
		result = pdt.numOfPointsInRange(XLeft, XRight);
		testExpected(testName, expected, result);

		XLeft=1;
		XRight=3;
		testName = "B2.1";
		double expectedD = 97.0;
		double resultD = pdt.averageHeightInRange(XLeft, XRight);
		testExpected(testName, expectedD, resultD);
		testName = "B2.2";
		XLeft=0;
		XRight=NUM;
		expectedD =((double) (NUM-1)*NUM)/(2*NUM);
		resultD = pdt.averageHeightInRange(XLeft, XRight);
		testExpected(testName, expectedD, resultD);

		XLeft=7;
		XRight=12;
		testName = "B3";
		Point[] expectedPoints1=
				{
						new Point(7,NUM-7-1),
						new Point(8,NUM-8-1),
						new Point(9,NUM-9-1),
						new Point(10,NUM-10-1),
						new Point(11,NUM-11-1),
						new Point(12,NUM-12-1),
				};
		testExpectedPoints(testName, expectedPoints1, pdt.getPointsInRange(XLeft,XRight));


		int k=6;
		testName = "B4";
		int mid=NUM/2;
		Point[] expectedPoints2=
				{
						new Point(NUM-mid-1,mid),
						new Point(NUM-(mid-1)-1,mid-1),
						new Point(NUM-(mid+1)-1,mid+1),
						new Point(NUM-(mid-2)-1,mid-2),
						new Point(NUM-(mid+2)-1,mid+2),
						new Point(NUM-(mid-3)-1,mid-3),
				};
		testExpectedPoints(testName, expectedPoints2, pdt.getMedianPoints(k));

		testName = "B5";
		Point[] expectedPoints3=
				{
						new Point(NUM-mid-1,mid),
						new Point(NUM-(mid-1)-1,mid-1),
						new Point(NUM-(mid+1)-1,mid+1),
						new Point(NUM-(mid-2)-1,mid-2),
						new Point(NUM-(mid+2)-1,mid+2),
						new Point(NUM-(mid-3)-1,mid-3),
						new Point(NUM-(mid+3)-1,mid+3),
				};
		testExpectedPoints(testName, expectedPoints3, pdt.getMedianPoints(k+1));

		pdt.addPoint(new Point(NUM,NUM));


		testName = "B6.1";
		Point[] expectedPoints4=
				{
						new Point(NUM-mid-1,mid),
						new Point(NUM-(mid-1)-1,mid-1),
						new Point(NUM-(mid+1)-1,mid+1),
						new Point(NUM-(mid-2)-1,mid-2),
						new Point(NUM-(mid+2)-1,mid+2),
						new Point(NUM-(mid-3)-1,mid-3),
				};
		testExpectedPoints(testName, expectedPoints4, pdt.getMedianPoints(k));

		testName = "B6.2";
		Point[] expectedPoints5=
				{
						new Point(NUM-mid-1,mid),
						new Point(NUM-(mid-1)-1,mid-1),
						new Point(NUM-(mid+1)-1,mid+1),
						new Point(NUM-(mid-2)-1,mid-2),
						new Point(NUM-(mid+2)-1,mid+2),
						new Point(NUM-(mid-3)-1,mid-3),
						new Point(NUM-(mid+3)-1,mid+3),
				};
		testExpectedPoints(testName, expectedPoints5, pdt.getMedianPoints(k+1));

		XLeft=1;
		XRight=3;
		testName = "B6.3";
		expectedD = 97.0;
		resultD = pdt.averageHeightInRange(XLeft, XRight);
		testExpected(testName, expectedD, resultD);
		testName = "B6.4";
		XLeft=0;
		XRight=NUM;
		expectedD =((double) (NUM)*(NUM+1))/(2*(NUM+1));
		resultD = pdt.averageHeightInRange(XLeft, XRight);
		testExpected(testName, expectedD, resultD);

		pdt.removeMedianPoint();

		testName = "B7.1";
		Point[] expectedPoints6=
				{
						//new Point(NUM-mid-1,mid),
						new Point(NUM-(mid-1)-1,mid-1),
						new Point(NUM-(mid+1)-1,mid+1),
						new Point(NUM-(mid-2)-1,mid-2),
						new Point(NUM-(mid+2)-1,mid+2),
						new Point(NUM-(mid-3)-1,mid-3),
						new Point(NUM-(mid+3)-1,mid+3),
				};
		testExpectedPoints(testName, expectedPoints6, pdt.getMedianPoints(k));

		testName = "B7.2";
		Point[] expectedPoints7=
				{
						//new Point(NUM-mid-1,mid),
						new Point(NUM-(mid-1)-1,mid-1),
						new Point(NUM-(mid+1)-1,mid+1),
						new Point(NUM-(mid-2)-1,mid-2),
						new Point(NUM-(mid+2)-1,mid+2),
						new Point(NUM-(mid-3)-1,mid-3),
						new Point(NUM-(mid+3)-1,mid+3),
						//
						new Point(NUM-(mid+4)-1,mid+4),
				};
		testExpectedPoints(testName, expectedPoints7, pdt.getMedianPoints(k+1));
	}



	private static void testC()
	{


		Point[] points = {

				new Point(11, 25),
				new Point(12, 26),
				new Point(13, 27),
				new Point(14, 37),
				new Point(7, 20),
				new Point(0, 3),
				new Point(1, 7),
				new Point(2, 8),
				new Point(3, 10),
				new Point(4, 12),
				new Point(5, 13),
				new Point(6, 15),
				new Point(8, 21),
				new Point(9, 22),
				new Point(10,23),
				new Point(15, 60),
				new Point(16, 63),
				new Point(17, 70),
				new Point(22, 80),
				new Point(23, 85),
				new Point(24, 86),
				new Point(25, 88),
				new Point(26, 89),
				new Point(27, 93),
				new Point(28, 96),
				new Point(29, 100),
				new Point(30, 105),
				new Point(18, 73),
				new Point(19, 75),
				new Point(20, 76),
				new Point(21, 77)
		};
		PDT pdt=new PointDataStructure(points,points[15]);
		String testName;
		int expected;
		int result;

		System.out.println("A-test medians");
		System.out.println("B-test number of points in range");
		System.out.println("C-test average");
		System.out.println("D- get points in range");
		System.out.println("testNumber <10 - before adding new points and deleting medians");
		System.out.println("testNumber >10 - after adding points and deleting medians");


		testName = "A0";
		testExpectedPoints(testName, points, pdt.getAllPoints());

		testName = "A1";
		Point[] expectedPoints1 = {
				new Point(15, 60),
		};
		testExpectedPoints(testName, expectedPoints1, pdt.getMedianPoints(1));
		testName = "A2";
		Point[] expectedPoints2 = {
				new Point(14, 37),
				new Point(15, 60)

		};
		testExpectedPoints(testName, expectedPoints2, pdt.getMedianPoints(2));


		testName = "A4";
		Point[] expectedPoints4 = {
				new Point(11, 25),
				new Point(12, 26),
				new Point(13, 27),
				new Point(14, 37),
				new Point(15, 60),
				new Point(16, 63),
				new Point(17, 70),
				new Point(18, 73)
		};
		testExpectedPoints(testName, expectedPoints4, pdt.getMedianPoints(8));

		testName = "A5";
		Point[] expectedPoints5 = {
				new Point(11, 25),
				new Point(12, 26),
				new Point(13, 27),
				new Point(14, 37),
				new Point(15, 60),
				new Point(16, 63),
				new Point(17, 70),
				new Point(18, 73),
				new Point(19, 75)

		};
		testExpectedPoints(testName, expectedPoints5, pdt.getMedianPoints(9));

		int XLeft=0;
		int XRight=0;
		testName = "B0";
		expected = 1;
		result = pdt.numOfPointsInRange(XLeft, XRight);
		testExpected(testName, expected, result);

		XLeft=100;
		XRight=101;
		testName = "B1";
		expected = 0;
		result = pdt.numOfPointsInRange(XLeft, XRight);
		testExpected(testName, expected, result);

		XLeft=0;
		XRight=35;
		testName = "B2";
		expected = 31;
		result = pdt.numOfPointsInRange(XLeft, XRight);
		testExpected(testName, expected, result);

		XLeft=0;
		XRight=30;
		testName = "B3";
		expected = 31;
		result = pdt.numOfPointsInRange(XLeft, XRight);
		testExpected(testName, expected, result);

		XLeft=2;
		XRight=30;
		testName = "B3";
		expected = 29;
		result = pdt.numOfPointsInRange(XLeft, XRight);
		testExpected(testName, expected, result);

		XLeft=12;
		XRight=16;
		testName = "B4";
		expected = 5;
		result = pdt.numOfPointsInRange(XLeft, XRight);
		testExpected(testName, expected, result);

		XLeft=15;
		XRight=15;
		testName = "B5";
		expected = 1;
		result = pdt.numOfPointsInRange(XLeft, XRight);
		testExpected(testName, expected, result);

		XLeft=3;
		XRight=23;
		testName = "B6";
		expected = 21;
		result = pdt.numOfPointsInRange(XLeft, XRight);
		testExpected(testName, expected, result);

		XLeft=-2;
		XRight=132;
		testName = "B7";
		expected = 31;
		result = pdt.numOfPointsInRange(XLeft, XRight);
		testExpected(testName, expected, result);

		XLeft=16;
		XRight=25;
		testName = "B8";
		expected = 	10;
		result = pdt.numOfPointsInRange(XLeft, XRight);
		testExpected(testName, expected, result);



		XLeft=1;
		XRight=1;
		testName = "C0";
		double expectedD = 7.0;
		double resultD = pdt.averageHeightInRange(XLeft, XRight);
		testExpected(testName, expectedD, resultD);

		XLeft=0;
		XRight=1;
		testName = "C1";
		expectedD = 5.0;
		resultD = pdt.averageHeightInRange(XLeft, XRight);
		testExpected(testName, expectedD, resultD);

		XLeft=2;
		XRight=6;
		testName = "C2";
		expectedD = 11.6;
		resultD = pdt.averageHeightInRange(XLeft, XRight);
		testExpected(testName, expectedD, resultD);

		XLeft=15;
		XRight=16;
		testName = "C3";
		expectedD = 61.5;
		resultD = pdt.averageHeightInRange(XLeft, XRight);
		testExpected(testName, expectedD, resultD);

		XLeft=14;
		XRight=16;
		testName = "C4";
		expectedD = 160/3.0;
		resultD = pdt.averageHeightInRange(XLeft, XRight);
		testExpected(testName, expectedD, resultD);

		XLeft=25;
		XRight=28;
		testName = "C5";
		expectedD = 91.5;
		resultD = pdt.averageHeightInRange(XLeft, XRight);
		testExpected(testName, expectedD, resultD);

		XLeft=4;
		XRight=26;
		testName = "C7";
		expectedD = 1163/23.0;
		resultD = pdt.averageHeightInRange(XLeft, XRight);
		testExpected(testName, expectedD, resultD);

		XLeft=30;
		XRight=39;
		testName = "C8";
		expectedD = 105.0;
		resultD = pdt.averageHeightInRange(XLeft, XRight);
		testExpected(testName, expectedD, resultD);

		XLeft=37;
		XRight=39;
		testName = "C9";
		expectedD = 0.0;
		resultD = pdt.averageHeightInRange(XLeft, XRight);
		testExpected(testName, expectedD, resultD);

		XLeft=-2;
		XRight=-1;
		testName = "C10";
		expectedD = 0.0;
		resultD = pdt.averageHeightInRange(XLeft, XRight);
		testExpected(testName, expectedD, resultD);


		testName = "D0";
		XLeft=15;
		XRight=15;
		Point[] expectedPoint0 = {
				new Point(15, 60)
		};
		testExpectedPoints(testName, expectedPoint0, pdt.getPointsInRange(XLeft, XRight));

		testName = "D1";
		XLeft=35;
		XRight=37;
		Point[] expectedPoint1 = new Point[0];
		testExpectedPoints(testName, expectedPoint1, pdt.getPointsInRange(XLeft, XRight));
//

		testName = "D2";
		XLeft=13;
		XRight=20;
		Point[] expectedPoint2 = {
				new Point(13, 27),
				new Point(14, 37),
				new Point(15, 60),
				new Point(16, 63),
				new Point(17, 70),
				new Point(18, 73),
				new Point(19, 75),
				new Point(20, 76)
		};
		testExpectedPoints(testName, expectedPoint2, pdt.getPointsInRange(XLeft, XRight));

		testName = "D3";
		XLeft=17;
		XRight=24;
		Point[] expectedPoint3 = {
				new Point(17, 70),
				new Point(18, 73),
				new Point(19, 75),
				new Point(20, 76),
				new Point(21, 77),
				new Point(22, 80),
				new Point(23, 85),
				new Point(24, 86)

		};
		testExpectedPoints(testName, expectedPoint3, pdt.getPointsInRange(XLeft, XRight));


		testName = "D4";
		XLeft=0;
		XRight=39;
		Point[] expectedPoint4 = {

				new Point(0, 3),
				new Point(1, 7),
				new Point(2, 8),
				new Point(3, 10),
				new Point(4, 12),
				new Point(5, 13),
				new Point(6, 15),
				new Point(7, 20),
				new Point(8, 21),
				new Point(9, 22),
				new Point(10,23),
				new Point(11, 25),
				new Point(12, 26),
				new Point(13, 27),
				new Point(14, 37),
				new Point(15, 60),
				new Point(16, 63),
				new Point(17, 70),
				new Point(18, 73),
				new Point(19, 75),
				new Point(20, 76),
				new Point(21, 77),
				new Point(22, 80),
				new Point(23, 85),
				new Point(24, 86),
				new Point(25, 88),
				new Point(26, 89),
				new Point(27, 93),
				new Point(28, 96),
				new Point(29, 100),
				new Point(30, 105)


		};
		testExpectedPoints(testName, expectedPoint4, pdt.getPointsInRange(XLeft, XRight));

		testName = "D5";
		XLeft=8;
		XRight=16;
		Point[] expectedPoint5 = {

//				new Point(0, 3),
//				new Point(1, 7),
//				new Point(2, 8),
//				new Point(3, 10),
//				new Point(4, 12),
//				new Point(5, 13),
//				new Point(6, 15),
//				new Point(7, 20),
				new Point(8, 21),
				new Point(9, 22),
				new Point(10,23),
				new Point(11, 25),
				new Point(12, 26),
				new Point(13, 27),
				new Point(14, 37),
				new Point(15, 60),
				new Point(16, 63)
//				new Point(17, 70),
//				new Point(18, 73),
//				new Point(19, 75),
//				new Point(20, 76),
//				new Point(21, 77),
//				new Point(22, 80),
//				new Point(23, 85),
//				new Point(24, 86),
//				new Point(25, 88),
//				new Point(26, 89),
//				new Point(27, 93),
//				new Point(28, 96),
//				new Point(29, 100),
//				new Point(30, 105)
//

		};
		testExpectedPoints(testName, expectedPoint5, pdt.getPointsInRange(XLeft, XRight));


		//--------------------------------------------
		System.out.println("removed one median point ("+(pdt.getMedianPoints(1))[0].getX()+","+(pdt.getMedianPoints(1))[0].getY()+")");
		pdt.removeMedianPoint();

		//removed one median <15,60>


		testName = "A11";
		Point[] expectedPoints11 = {
				new Point(16, 63)
		};
		testExpectedPoints(testName, expectedPoints11, pdt.getMedianPoints(1));

		testName = "A12";
		Point[] expectedPoints12 = {

				new Point(11, 25),
				new Point(12, 26),
				new Point(13, 27),
				new Point(14, 37),
				new Point(16, 63),
				new Point(17, 70),
				new Point(18, 73),
				new Point(19, 75),
				new Point(20, 76)

		};
		testExpectedPoints(testName, expectedPoints12, pdt.getMedianPoints(9));


		XLeft=15;
		XRight=15;
		testName = "B11";
		expected = 0;
		result = pdt.numOfPointsInRange(XLeft, XRight);
		testExpected(testName, expected, result);

		XLeft=12;
		XRight=16;
		testName = "B12";
		expected = 4;
		result = pdt.numOfPointsInRange(XLeft, XRight);
		testExpected(testName, expected, result);

		XLeft=4;
		XRight=19;
		testName = "B13";
		expected = 15;
		result = pdt.numOfPointsInRange(XLeft, XRight);
		testExpected(testName, expected, result);

		XLeft=16;
		XRight=25;
		testName = "B14";
		expected = 10;
		result = pdt.numOfPointsInRange(XLeft, XRight);
		testExpected(testName, expected, result);



		XLeft=19;
		XRight=25;
		testName = "B15";
		expected = 7;
		result = pdt.numOfPointsInRange(XLeft, XRight);
		testExpected(testName, expected, result);



		System.out.println("removed one median point ("+(pdt.getMedianPoints(1))[0].getX()+","+(pdt.getMedianPoints(1))[0].getY()+")");
		pdt.removeMedianPoint();
		//removed another one



		testName = "A13";
		Point[] expectedPoints13 = {
				new Point(14, 37)
		};
		testExpectedPoints(testName, expectedPoints13, pdt.getMedianPoints(1));

		Point toAdd1=new Point (31,66);
		//add point
		pdt.addPoint(toAdd1);
		Point toAdd2=new Point (32,97);
		Point toAdd3=new Point (33,78);
		pdt.addPoint(toAdd2);
		pdt.addPoint(toAdd3);

		testName = "A14";
		Point[] expectedPoints14 = {

				new Point(31, 66),
				new Point(17, 70)

		};
		testExpectedPoints(testName, expectedPoints14, pdt.getMedianPoints(2));

		testName = "A15";
		Point[] expectedPoints15 = {


				new Point(17, 70)

		};
		testExpectedPoints(testName, expectedPoints15, pdt.getMedianPoints(1));

		testName = "A16";
		Point[] expectedPoints16 = {


				new Point(12, 26),
				new Point(13, 27),
				new Point(14, 37),
				new Point(31, 66),
				new Point(17, 70),
				new Point(18, 73),
				new Point(19, 75),
				new Point(20, 76),
				new Point(21, 77)

		};
		testExpectedPoints(testName, expectedPoints16, pdt.getMedianPoints(9));



		XLeft=14;
		XRight=18;
		testName = "B16";
		expected = 3;
		result = pdt.numOfPointsInRange(XLeft, XRight);
		testExpected(testName, expected, result);

		XLeft=0;
		XRight=33;
		testName = "B17";
		expected = 32;
		result = pdt.numOfPointsInRange(XLeft, XRight);
		testExpected(testName, expected, result);

		XLeft=17;
		XRight=21;
		testName = "B18";
		expected = 5;
		result = pdt.numOfPointsInRange(XLeft, XRight);
		testExpected(testName, expected, result);

		XLeft=30;
		XRight=31;
		testName = "C11";
		expectedD = 85.5;
		resultD = pdt.averageHeightInRange(XLeft, XRight);
		testExpected(testName, expectedD, resultD);


		XLeft=17;
		XRight=21;
		testName = "C12";
		expectedD = 74.2;
		resultD = pdt.averageHeightInRange(XLeft, XRight);
		testExpected(testName, expectedD, resultD);

		XLeft=10;
		XRight=20;
		testName = "C13";
		expectedD = 48.0;
		resultD = pdt.averageHeightInRange(XLeft, XRight);
		testExpected(testName, expectedD, resultD);


		testName = "D10";
		XLeft=13;
		XRight=17;
		Point[] expectedPoints10 = {

//				new Point(0, 3),
//				new Point(1, 7),
//				new Point(2, 8),
//				new Point(3, 10),
//				new Point(4, 12),
//				new Point(5, 13),
//				new Point(6, 15),
//				new Point(7, 20),
//				new Point(8, 21),
//				new Point(9, 22),
//				new Point(10,23),
//				new Point(11, 25),
//				new Point(12, 26),
				new Point(13, 27),
				new Point(14, 37),
//				new Point(15, 60),   -- deleted
//				new Point(16, 63)	 --deleted
//				new Point(31, 66) 	 -added
				new Point(17, 70)
//				new Point(18, 73),
//				new Point(19, 75),
//				new Point(20, 76),
//				new Point(21, 77),
//				new Point (33,78) 	-added
//				new Point(22, 80),
//				new Point(23, 85),
//				new Point(24, 86),
//				new Point(25, 88),
//				new Point(26, 89),
//				new Point(27, 93),
//				new Point(28, 96),
//				new Point(32, 97),   --added
//				new Point(29, 100),
//				new Point(30, 105)
//

		};
		testExpectedPoints(testName, expectedPoints10, pdt.getPointsInRange(XLeft, XRight));


		testName = "D11";
		XLeft=13;
		XRight=40;
		Point[] expectedPoint11 = {

//				new Point(0, 3),
//				new Point(1, 7),
//				new Point(2, 8),
//				new Point(3, 10),
//				new Point(4, 12),
//				new Point(5, 13),
//				new Point(6, 15),
//				new Point(7, 20),
//				new Point(8, 21),
//				new Point(9, 22),
//				new Point(10,23),
//				new Point(11, 25),
//				new Point(12, 26),
				new Point(13, 27),
				new Point(14, 37),
//				new Point(15, 60),   -- deleted
//				new Point(16, 63),	 --deleted
				new Point(31, 66),   //	 -added
				new Point(17, 70),
				new Point(18, 73),
				new Point(19, 75),
				new Point(20, 76),
				new Point(21, 77),
				new Point(33, 78), 	//-added
				new Point(22, 80),
				new Point(23, 85),
				new Point(24, 86),
				new Point(25, 88),
				new Point(26, 89),
				new Point(27, 93),
				new Point(28, 96),
				new Point(32, 97),   //--added
				new Point(29, 100),
				new Point(30, 105)


		};
		testExpectedPoints(testName, expectedPoint11, pdt.getPointsInRange(XLeft, XRight));

		testName = "D12";
		XLeft=0;
		XRight=40;
		Point[] expectedPoint12 = {

				new Point(0, 3),
				new Point(1, 7),
				new Point(2, 8),
				new Point(3, 10),
				new Point(4, 12),
				new Point(5, 13),
				new Point(6, 15),
				new Point(7, 20),
				new Point(8, 21),
				new Point(9, 22),
				new Point(10,23),
				new Point(11, 25),
				new Point(12, 26),
				new Point(13, 27),
				new Point(14, 37),
//				new Point(15, 60),   -- deleted
//				new Point(16, 63),	 --deleted
				new Point(31, 66),   //	 -added
				new Point(17, 70),
				new Point(18, 73),
				new Point(19, 75),
				new Point(20, 76),
				new Point(21, 77),
				new Point(33, 78), 	//-added
				new Point(22, 80),
				new Point(23, 85),
				new Point(24, 86),
				new Point(25, 88),
				new Point(26, 89),
				new Point(27, 93),
				new Point(28, 96),
				new Point(32, 97),   //--added
				new Point(29, 100),
				new Point(30, 105)


		};
		testExpectedPoints(testName, expectedPoint12, pdt.getPointsInRange(XLeft, XRight));


		//  add some more points to change median
		System.out.println("adding more 3 points: (34,115),(35,120),(36,130)");
		Point toAdd4 = new Point (34,115);
		Point toAdd5 = new Point (35,120);
		Point toAdd6 = new Point (36,130);
		pdt.addPoint(toAdd4);
		pdt.addPoint(toAdd5);
		pdt.addPoint(toAdd6);

		testName = "A17";  //test for getting all the points
		Point[] expectedPoints17 = {


				new Point(0, 3),
				new Point(1, 7),
				new Point(2, 8),
				new Point(3, 10),
				new Point(4, 12),
				new Point(5, 13),
				new Point(6, 15),
				new Point(7, 20),
				new Point(8, 21),
				new Point(9, 22),
				new Point(10,23),
				new Point(11, 25),
				new Point(12, 26),
				new Point(13, 27),
				new Point(14, 37),
//				new Point(15, 60),   -- deleted
//				new Point(16, 63),	 --deleted
				new Point(31, 66),   //	 -added
				new Point(17, 70),
				new Point(18, 73),
				new Point(19, 75),
				new Point(20, 76),
				new Point(21, 77),
				new Point(33, 78), 	//-added
				new Point(22, 80),
				new Point(23, 85),
				new Point(24, 86),
				new Point(25, 88),
				new Point(26, 89),
				new Point(27, 93),
				new Point(28, 96),
				new Point(32, 97),   //--added
				new Point(29, 100),
				new Point(30, 105),
				new Point(34, 115),  //added now
				new Point(35, 120),	//added now
				new Point(36, 130)	//added now

		};

		testExpectedPoints(testName, expectedPoints17, pdt.getAllPoints());


		testName = "A18";
		Point[] expectedPoints18 = {



				new Point(31, 66),
				new Point(17, 70),
				new Point(18, 73),
				new Point(19, 75)

		};
		testExpectedPoints(testName, expectedPoints18, pdt.getMedianPoints(4));

		XLeft=24;
		XRight=40;
		testName = "B19";
		expected = 13;
		result = pdt.numOfPointsInRange(XLeft, XRight);
		testExpected(testName, expected, result);

		XLeft=33;
		XRight=36;
		testName = "C14";
		expectedD = 443/4.0;
		resultD = pdt.averageHeightInRange(XLeft, XRight);
		testExpected(testName, expectedD, resultD);


		testName = "D13";
		XLeft=0;
		XRight=40;
		Point[] expectedPoint13 = {
				new Point(0, 3),
				new Point(1, 7),
				new Point(2, 8),
				new Point(3, 10),
				new Point(4, 12),
				new Point(5, 13),
				new Point(6, 15),
				new Point(7, 20),
				new Point(8, 21),
				new Point(9, 22),
				new Point(10,23),
				new Point(11, 25),
				new Point(12, 26),
				new Point(13, 27),
				new Point(14, 37),
//				new Point(15, 60),   -- deleted
//				new Point(16, 63),	 --deleted
				new Point(31, 66),   //	 -added
				new Point(17, 70),
				new Point(18, 73),
				new Point(19, 75),
				new Point(20, 76),
				new Point(21, 77),
				new Point(33, 78), 	//-added
				new Point(22, 80),
				new Point(23, 85),
				new Point(24, 86),
				new Point(25, 88),
				new Point(26, 89),
				new Point(27, 93),
				new Point(28, 96),
				new Point(32, 97),   //--added
				new Point(29, 100),
				new Point(30, 105),
				new Point(34, 115),  //added now
				new Point(35, 120),	//added now
				new Point(36, 130)	//added now


		};
		testExpectedPoints(testName, expectedPoint13, pdt.getPointsInRange(XLeft, XRight));







	}

	private static class PointCompare implements Comparator<Point>
	{

		@Override
		public int compare(Point point1, Point point2)
		{
			if (point1.getY()<point2.getY()) return -1;
			else if (point1.getY()==point2.getY() && point1.getX()<point2.getX()) return -1;
			return 1;
		}

	}


	private static <T> void testExpected(String testName, T expected, T actual)
	{
		if (!actual.equals(expected)) {
			System.out.println("Test " +testName+ ": wrong! expected=" + expected + ", actual=" + actual);
		} else {
			System.out.println("Test " +testName+ ": passed :)");
		}

	}

	private static void testExpectedPoints(String testName, Point[] expectedPoints,	Point[] actualPoints)
	{
		if (!equalAsSets(actualPoints,expectedPoints)) {
			System.out.println("Test " +testName+ ": wrong! expected=" + Arrays.toString(expectedPoints) + ", actual=" + Arrays.toString(actualPoints));
		} else {
			System.out.println("Test " +testName+ ": passed :)");
		}
	}

	//checks (inefficiently) that the sets are equal
	//NOTE: if one of the sets contains 2 points with same coordinates, might return erroneous result
	private static boolean equalAsSets(Point[] actualPoints, Point[] expectedPoints)
	{
		if (actualPoints.length!=expectedPoints.length) return false;
		for (int i=0;i<expectedPoints.length;i++)
		{
			boolean exists=false;
			for (int j=0;j<actualPoints.length;j++)
			{
				if (expectedPoints[i].equals(actualPoints[j])) exists=true;
			}
			if (!exists) return false;
		}
		return true;
	}


	private static Point[] readPointsFile(String fileName)
	{
		Vector<Point> points = new Vector<Point>();;
		BufferedReader input;
		FileReader fileReader;

		try {
			fileReader = new FileReader(fileName);
			input = new BufferedReader(fileReader);
			String line = null;
			String name;
			int x, y;

			while ((line = input.readLine()) != null) {
				String[] lineArray = line.split(";");
				name = lineArray[0];
				x = Integer.parseInt(lineArray[1]);
				y = Integer.parseInt(lineArray[2]);

				Point p = new Point(x, y, name);
				points.add(p);
			}
			input.close();
			fileReader.close();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		Point[] result = new Point[points.size()];
		points.toArray(result);
		return result;
	}

}
