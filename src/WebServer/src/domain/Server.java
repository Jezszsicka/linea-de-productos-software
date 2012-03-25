package domain;



public class Server extends Ice.Application{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Server server = new Server();
		int status = server.main("Server", args, "config.server");
		System.exit(status);
	}

	@Override
	public int run(String[] args) {
		/*if (args.length > 0) {
			System.err.println(appName() + ": too many arguments");
			return 1;
		}*/

		Ice.ObjectAdapter adapter = communicator().createObjectAdapter(
				"ProductLine.Server");
		ServerI server = new ServerI(communicator());
		adapter.add(server, communicator().stringToIdentity("sender"));
		adapter.activate();
	//	Thread t = new Thread(server);
	//	t.start();
		
		try {
			communicator().waitForShutdown();
		} finally {
		/*	//server.destroy();
			try {
				t.join();
			} catch (java.lang.InterruptedException ex) {
			}*/
		}

		return 0;
	}

}
