/**
 * 
 */
package org.irods.jargon.dataone.reposervice;

import java.util.Date;
import java.util.List;

import org.dataone.service.types.v1.Identifier;
import org.dataone.service.types.v1.ObjectFormatIdentifier;
import org.irods.jargon.core.connection.IRODSAccount;
import org.irods.jargon.core.exception.JargonException;
import org.irods.jargon.dataone.configuration.PublicationContext;
import org.irods.jargon.dataone.plugin.AbstractDataOnePlugin;

/**
 * Abstract implementation of a dataone repo service. This service is in charge
 * of coordinating data objects that are to be provided to DataONE polling
 * 
 * @author mconway
 *
 */
public abstract class AbstractDataOneRepoAO extends AbstractDataOnePlugin implements DataOneRepoAO {

	/**
	 * Default constructor with required values
	 * 
	 * @param irodsAccount
	 *            {@link IRODSAccount} for the current iRODS connection
	 * @param publicationContext
	 *            {@link PublicationContext} with configuration and other
	 *            information
	 */
	public AbstractDataOneRepoAO(IRODSAccount irodsAccount, PublicationContext publicationContext) {
		super(irodsAccount, publicationContext);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.irods.jargon.dataone.reposervice.DataOneRepoAO#
	 * getListOfDataoneExposedIdentifiers()
	 */
	@Override
	public abstract List<Identifier> getListOfDataoneExposedIdentifiers() throws JargonException;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.irods.jargon.dataone.reposervice.DataOneRepoAO#
	 * getListOfDataoneExposedDataObjects(java.util.Date, java.util.Date,
	 * org.dataone.service.types.v1.ObjectFormatIdentifier, java.lang.Boolean,
	 * java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public abstract DataObjectListResponse getListOfDataoneExposedDataObjects(Date fromDate, Date toDate,
			ObjectFormatIdentifier formatId, Boolean replicaStatus, Integer start, Integer count)
			throws JargonException;

}
