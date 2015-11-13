/*

Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.



xA, yA bottom left corner for rect A
xB, yB top right corner for rect B
xC, yC bottom left corner for rect C
xD, yD top right corner for rect D

1. determine if they are intersected
	if (xA - xC) * (xA - xD) < 0 or (xB - xC) * (xB - xD)
		x is intersected
	if (yA - yC) * (yA - yD) < 0 or (yB - yC) * (yB - yD)
		y is intersected
	if x and y are intersected 
		calculate the area
		length = lengthA + lenthB - (maxX - minX)
		width = widthA + widthB - (maxY - minY)
		area = length * width
	return area


*/



public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        boolean xIntersect = false;
        boolean yIntersect = false;
        if((A - E) * (A - G) <= 0 || (C - E) * (C - G) <= 0) xIntersect = true;
        if((D - H) * (D - F) <= 0 || (B - H) * (B - F) <= 0) yIntersect = true;
        if(xIntersect && yIntersect){
        	int l = Math.abs(A - C) + Math.abs(E - G) - (Math.max(Math.max(A, C), Math.max(E, G)) - Math.min(Math.min(A, C), Math.min(E, G)));
        	int w = Math.abs(D - B) + Math.abs(H - F) - (Math.max(Math.max(D, B), Math.max(H, F)) - Math.min(Math.min(D, B), Math.min(H, F)));
        	return l * w;
        }	
        else return 0;
    }
}