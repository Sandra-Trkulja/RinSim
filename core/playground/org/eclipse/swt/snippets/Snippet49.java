package org.eclipse.swt.snippets;

/*
 * ToolBar example snippet: create tool bar (wrap on resize)
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class Snippet49 {

	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		final ToolBar toolBar = new ToolBar(shell, SWT.WRAP);
		for (int i = 0; i < 12; i++) {
			ToolItem item = new ToolItem(toolBar, SWT.PUSH);
			item.setText("Item " + i);
		}
		shell.addListener(SWT.Resize, new Listener() {
			@Override
			public void handleEvent(Event e) {
				Rectangle rect = shell.getClientArea();
				Point size = toolBar.computeSize(rect.width, SWT.DEFAULT);
				toolBar.setSize(size);
			}
		});
		Rectangle clientArea = shell.getClientArea();
		toolBar.setLocation(clientArea.x, clientArea.y);
		toolBar.pack();
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}