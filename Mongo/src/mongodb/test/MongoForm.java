package mongodb.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MongoForm extends Shell {
	private Text textInput;
	private Text textOutput;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			MongoForm shell = new MongoForm(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public MongoForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		textInput = new Text(this, SWT.BORDER);
		textInput.setBounds(10, 41, 76, 21);
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String input = textInput.getText();
				textOutput.append(FindMongoDoc.findMongoDoc(input));			}
		});
		btnNewButton.setBounds(107, 39, 75, 25);
		btnNewButton.setText("Esegui");
		
		textOutput = new Text(this, SWT.BORDER);
		textOutput.setBounds(10, 104, 398, 148);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(450, 300);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
