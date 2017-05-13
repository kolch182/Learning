package ch.gmtech.ste.controller;

import java.sql.Connection;

public interface Controller {
	void execute(Connection connection) throws Exception;
}
