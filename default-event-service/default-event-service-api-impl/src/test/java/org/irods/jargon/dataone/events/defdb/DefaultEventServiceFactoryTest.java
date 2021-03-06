package org.irods.jargon.dataone.events.defdb;

import org.irods.jargon.core.connection.IRODSAccount;
import org.irods.jargon.core.pub.IRODSAccessObjectFactory;
import org.irods.jargon.dataone.events.AbstractDataOneEventServiceAO;
import org.irods.jargon.dataone.plugin.PublicationContext;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class DefaultEventServiceFactoryTest {

	@Test
	public void testLoadFromFactory() throws Exception {
		IRODSAccount dummyAccount = IRODSAccount.instance("host", 1247, "user", "pwd", "", "zone", "");
		IRODSAccessObjectFactory iaf = Mockito.mock(IRODSAccessObjectFactory.class);
		PublicationContext context = new PublicationContext();
		context.setIrodsAccessObjectFactory(iaf);
		DefaultEventServiceFactory defaultEventServiceFactory = new DefaultEventServiceFactory();
		AbstractDataOneEventServiceAO dataOneEventServiceAO = defaultEventServiceFactory.instance(context,
				dummyAccount);
		Assert.assertNotNull("no event service created", dataOneEventServiceAO);

	}

}
