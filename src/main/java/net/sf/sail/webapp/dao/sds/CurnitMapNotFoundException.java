/**
 * Copyright (c) 2007 Encore Research Group, University of Toronto
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
package net.sf.sail.webapp.dao.sds;

import net.sf.sail.webapp.domain.sds.SdsOffering;

/**
 * This exception is thrown when a curnitmap is not retrieved for whatever
 * reason. When the exception is thrown you can preserve the sdsoffering by
 * saving it within this exception, and then retreiving it when the exception is
 * caught.
 * 
 * @author Laurel Williams
 * 
 * @version $Id$
 */
public class CurnitMapNotFoundException extends HttpStatusCodeException {

	private SdsOffering sdsOffering;

	/**
	 * @return the sdsOffering
	 */
	public SdsOffering getSdsOffering() {
		return sdsOffering;
	}

	/**
	 * @param sdsOffering
	 *            the sdsOffering to set
	 */
	public void setSdsOffering(SdsOffering sdsOffering) {
		this.sdsOffering = sdsOffering;
	}

	public CurnitMapNotFoundException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;
}
