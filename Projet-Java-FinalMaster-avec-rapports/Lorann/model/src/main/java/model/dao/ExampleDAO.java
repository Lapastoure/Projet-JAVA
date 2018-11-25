package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Example;

/**
 * <h1>The Class ExampleDAO.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class ExampleDAO extends AbstractDAO {

	/** The sql example by id. */
	private static String sqlIssou = "{call niveau1()}";

	/** The id column index. */
	private static int ID_SpriteColumnIndex = 2;

	private static int XColumnIndex = 3;

	private static int YColumnIndex = 4;

	/**
	 * Gets the example by id.
	 *
	 * @param id
	 *            the id
	 * @return the example by id
	 * @throws SQLException
	 *             the SQL exception
	 */

	/**
	 * Gets the example by name.
	 *
	 * @param name
	 *            the name
	 * @return the example by name
	 * @throws SQLException
	 *             the SQL exception
	 */
	public static ArrayList<Example> getNiveau1() throws SQLException {
		final ArrayList<Example> examples = new ArrayList<Example>();
		final CallableStatement callStatement = prepareCall(sqlIssou);
		if (callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
			for (boolean isResultLeft = result.first(); isResultLeft; isResultLeft = result.next()) {
				examples.add(new Example(result.getInt(XColumnIndex), result.getInt(YColumnIndex),
						result.getInt(ID_SpriteColumnIndex)));

			}
			result.close();

		}
		return examples;
	}

}
