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

package de.fhg.igd.pcolor;

import de.fhg.igd.pcolor.colorspace.CS_Jab;

/**
 * Jab is a three-component space derived from the CIECAM02 color appearance
 * model, where J represents lightness, a represents red-green color, and b
 * represents yellow-blue color. The advantage of using CIECAM02's red-green (a)
 * and yellow-blue (b) correlates is that the colorspace is Euclidian (as
 * opposed to JCh, which uses a polar coordinate system) and can therefore be
 * used for convolution filtering or rescaling.
 */
public class Jab extends PColor {
	/**
	 * Lightness
	 */
	public static final int J = 0;

	/**
	 * Red-Green
	 */
	public static final int a = 1;

	/**
	 * Yellow-Blue
	 */
	public static final int b = 2;

	/**
	 * 
	 * @param color color
	 */
	public Jab(PColor color) {
		this(color, new CS_Jab());
	}

	/**
	 * 
	 * @param color color
	 * @param cspace Jab color space
	 */
	public Jab(PColor color, CS_Jab cspace) {
		super(cspace, color);
	}

	/**
	 * with 1 as alpha value
	 * @param J Lightness
	 * @param a Red-Green
	 * @param b Yellow-Blue
	 */
	public Jab(float J, float a, float b) {
		this(J, a, b, 1f);
	}

	/**
	 * 
	 * @param J Lightness
	 * @param a Red-Green
	 * @param b Yellow-Blue
	 * @param alpha alpha value
	 */
	public Jab(float J, float a, float b, float alpha) {
		super(new CS_Jab(), new float[] {J, a, b}, alpha);
	}

	/**
	 * 
	 * @param J Lightness
	 * @param a Red-Green
	 * @param b Yellow-Blue
	 * @param alpha alpha value
	 * @param cspace Jab color space
	 */
	public Jab(float J, float a, float b, float alpha, CS_Jab cspace) {
		super(cspace, new float[] {J, a, b}, alpha);
	}

	@Override
	public Jab convertFrom(PColor color) {
		return new Jab(color, (CS_Jab)this.getColorSpace());
	}

	@Override
	public Jab clone() {
		return new Jab(this);
	}
}