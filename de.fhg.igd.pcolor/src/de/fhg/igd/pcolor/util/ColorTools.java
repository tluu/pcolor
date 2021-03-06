// Copyright (c) 2012 Fraunhofer IGD
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to 
// deal in the Software without restriction, including without limitation the 
// rights to use, copy, modify, merge, publish, distribute, sublicense, and/or 
// sell copies of the Software, and to permit persons to whom the Software is 
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in 
// all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR 
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE 
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING  
// FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
// DEALINGS IN THE SOFTWARE.

package de.fhg.igd.pcolor.util;

import java.util.ArrayList;
import java.util.Arrays;
import de.fhg.igd.pcolor.PColor;

/**
 * A series of methods and utilities for dealing with various color operations.
 */
public class ColorTools {

	/**
	 * Returns a new ArrayList<C> in which all duplicate instances of any
	 * given color in list have been removed, leaving only unique colors.
	 */
    public static <C extends PColor> ArrayList<C> getUniqueColors(C[] list) {
    	ArrayList<C> colorList = new ArrayList<C>();
    	for(int i = 0; i < list.length; i++) {
    		// get components
    		float[] components = list[i].getRawComponents();
    		// test for repeats
    		boolean repeat = false;
    		for(int j = 0; j < colorList.size(); j++) {
    			if(Arrays.equals(colorList.get(j).getRawComponents(), components))
    				repeat = true;
    		}
    		// if not, add to list
    		if(!repeat)
    			colorList.add(list[i]);
    	}
    	return colorList;
    }

    /**
	 * Calculates an angle, in degrees, between 0 and 360 given its sine and
	 * cosine values.
	 */
    public static double calculateAtan(double cos, double sin) {
    	double result = Math.toDegrees(Math.atan2(sin , cos)); 
    	if(result < 0) 
    		return 360 + result;
    	else
    		return result; 
    }

    /**
	 * Returns the smallest difference between two hues as a positive float
	 * (in degrees).
	 * 
	 * @return Smallest difference between two hues.
	 */
    public static float hueDistance(float hue1, float hue2)
    {
	    float difference = (hue1 - hue2) % 360;
		if (difference > 180)
			difference -= 360;
		if (difference < -180)
			difference += 360;
		return Math.abs(difference);
    }

    /**
	 * Returns the smallest difference between two hues as a float (in degrees);
	 * negative values mean that hue2 is closer in the 'negative' direction (for
	 * instance, if hue1 is 5.0, and hue2 is 0.0, this function will return
	 * -5.0).
	 */
    public static float hueDifference(float hue1, float hue2)
    {
	    float difference = (hue2 - hue1) % 360;
		if (difference > 180)
			difference -= 360;
		if (difference < -180)
			difference += 360;
		return difference;
    }
}