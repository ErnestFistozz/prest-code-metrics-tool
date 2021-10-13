package prestgui;

import java.awt.Point;

import javax.swing.JFrame;

import com.sd.dev.lib.ISDContext;
import com.sd.dev.lib.ISDFile;
import com.sd.dev.lib.ISDTool;
import com.sd.dev.lib.SDOfflineContext;

/**
 * (c) SoftLab  
 * @author TurgayA  March 2009
 */

public class PrestGuiTool implements ISDTool
{ 
	public boolean instanceActivated()
	{
		PrestGuiApp inst = PrestGuiApp.getInstance();
		if (inst != null && !inst.isDisposed())
		{
			JFrame frame = inst.getFrameInstance();
			if (frame.getState() == JFrame.ICONIFIED)
				frame.setState(JFrame.NORMAL);
			frame.toFront();
			return true;
		}
		
		return false;
	}

	public boolean instanceDisposed()
	{
		PrestGuiApp inst = PrestGuiApp.getInstance();
		return inst == null || inst.isDisposed();
	}

	public boolean instanceMatchesFile(ISDFile arg0)
	{
		return true;
	}

	public boolean open(ISDContext context, ISDFile file, boolean modal, Point loc)
	{
		PrestGuiApp.setContext(context);
		PrestGuiApp.createInstance(null);
		return true;
	}

	public boolean run(ISDContext context, ISDFile file, boolean modal, Point loc)
	{
		return open(context, file, modal, loc);
	}

	public boolean openFile(ISDFile arg0)
	{
		return false;
	}

	public boolean runFile(ISDFile arg0)
	{
		return false;
	}

	public static void main(String[] args)
	{
       PrestGuiTool tool = new PrestGuiTool();
       tool.open(new SDOfflineContext(), null, false, null);
	}
}
