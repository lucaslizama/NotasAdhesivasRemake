/****************************************************************************************
 * 		*********************************************************		*
 *		* $Package: ZoeloeSoft.projects.JFontChooser		*		*
 *		* $Id: Test.java			 		*		*
 * 		* $Date: 23:40 19/04/2004				*		*
 *		*							*		*
 *	 	* $Creator: Tim Eeckhaut				*		*
 *		* $Alias: zoeloeboeloe					*		*
 *		*							*		*
 * 		* $Company: ZoeloeSoft					*		*
 *	 	* $Website: http://users.pandora.be/ZoeloeSoft		*		*
 *		*********************************************************		*
 *											*
 * Copyright (c) 2004, Tim Eeckhaut							*
 * All rights reserved.									*
 *											*
 * Redistribution and use in source and binary forms, with or without			*
 * modification, are permitted provided that the following conditions			*
 * are met:										*
 *											*
 * 	1. Redistributions of source code must retain the above copyright		*
 * notice, this list of conditions and the following disclaimer.			*
 *											*
 * 	2. Redistributions in binary form must reproduce the above copyright		*
 * notice, this list of conditions and the following disclaimer in the			*
 * documentation and/or other materials provided with the distribution.			*
 *											*
 * 	3. Neither the name of the company nor the names of its 			*
 * contributors may be used to endorse or promote products derived from this		*
 * software without specific prior written permission.					*
 *											*
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS			*
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT			*
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR		*
 * A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE REGENTS OR		*
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,		*
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,			*
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR			*
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF		*
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING			*
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS			*
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.				*
 *											*
 ***************************************************************************************/

package ZoeloeSoft.projects.JFontChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

import ZoeloeSoft.projects.JFontChooser.JFontChooser;

public class Test extends javax.swing.JFrame
{
	public Test()
	{
		super("JFontChooser Test");

		final JFontChooser chooser = new JFontChooser(this);	
		final JLabel lblText = new JLabel();

		JButton cmdChoose = new JButton("choose");
		cmdChoose.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent a)
			{
				int result = chooser.showDialog(lblText.getFont());

				if (result != JFontChooser.CANCEL_OPTION) 
				{
					lblText.setText("How about this font");
					lblText.setFont(chooser.getFont());
				}
				else lblText.setText("No font chosen");
			}
		});

		getContentPane().setLayout(new java.awt.GridLayout(2, 1));
		getContentPane().add(lblText);
		getContentPane().add(cmdChoose);

		setSize(200, 200);
		setVisible(true);
	}

	public static void main(String[] args)
	{
      		Test app = new Test();
	
		app.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
   	}
}