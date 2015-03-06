/*******************************************************************************
 * Copyright (c) 2013 Liviu Ionescu.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Liviu Ionescu - initial version
 *******************************************************************************/

package ilg.gnuarmeclipse.debug.gdbjtag.qemu;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

public class PersistentPreferences {

	// ------------------------------------------------------------------------

	// Tab Debugger
	// GDB Server Setup
	public static final String GDB_SERVER = "gdb.server.";

	public static final String GDB_SERVER_DO_START = GDB_SERVER + "doStart";

	public static final String GDB_SERVER_EXECUTABLE = GDB_SERVER
			+ "executable";

	public static final String GDB_SERVER_OTHER_OPTIONS = GDB_SERVER + "other";

	// GDB Client Setup
	public static final String GDB_CLIENT = "gdb.client.";

	public static final String GDB_CLIENT_EXECUTABLE = GDB_CLIENT
			+ "executable";

	public static final String GDB_CLIENT_OTHER_OPTIONS = GDB_CLIENT + "other";

	public static final String GDB_CLIENT_COMMANDS = GDB_CLIENT + "commands";

	// Tab Startup
	// Initialisation Commands
	public static final String GDB_QEMU = "gdb.qemu.";

	public static final String GDB_QEMU_DO_INITIAL_RESET = GDB_QEMU
			+ "doInitialReset";
	// public static final String GDB_QEMU_INITIAL_RESET_TYPE = GDB_QEMU
	// + "initialReset.type";
	public static final String GDB_QEMU_INIT_OTHER = GDB_QEMU + "init.other";

	public static final String GDB_QEMU_ENABLE_SEMIHOSTING = GDB_QEMU
			+ "enableSemihosting";

	public static final String GDB_QEMU_MACHINE_NAME = GDB_QEMU + "machineName";

	// Run Commands
	public static final String GDB_QEMU_DO_DEBUG_IN_RAM = GDB_QEMU
			+ "doDebugInRam";

	public static final String GDB_QEMU_DO_PRERUN_RESET = GDB_QEMU
			+ "doPreRunReset";
	// public static final String GDB_QEMU_PRERUN_RESET_TYPE = GDB_QEMU
	// + "preRunReset.type";

	public static final String GDB_QEMU_PRERUN_OTHER = GDB_QEMU
			+ "preRun.other";

	// ----- Defaults ---------------------------------------------------------

	public static final String EXECUTABLE_NAME = "executable.name";
	public static final String EXECUTABLE_NAME_OS = EXECUTABLE_NAME + ".%s";
	public static final String INSTALL_FOLDER = "install.folder";
	public static final String SEARCH_PATH = "search.path";
	public static final String SEARCH_PATH_OS = SEARCH_PATH + ".%s";

	public static final String FOLDER_STRICT = "folder.strict";

	public static final String TAB_MAIN_CHECK_PROGRAM = "tab.main.checkProgram";
	public static final boolean TAB_MAIN_CHECK_PROGRAM_DEFAULT = false;

	// ----- Getters ----------------------------------------------------------

	private static String getString(String id, String defaultValue) {

		return Platform.getPreferencesService().getString(Activator.PLUGIN_ID,
				id, defaultValue, null);
	}

	@SuppressWarnings("unused")
	private static boolean getBoolean(String id, boolean defaultValue) {

		return Platform.getPreferencesService().getBoolean(Activator.PLUGIN_ID,
				id, defaultValue, null);
	}

	// ----- Setters ----------------------------------------------------------

	private static void putWorkspaceString(String id, String value) {

		value = value.trim();

		// Access the instanceScope
		Preferences preferences = InstanceScope.INSTANCE
				.getNode(Activator.PLUGIN_ID);
		preferences.put(id, value);
	}

	public static void flush() {

		try {
			InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID).flush();
		} catch (BackingStoreException e) {
			Activator.log(e);
		}
	}

	// ----- gdb server doStart -----------------------------------------------
	public static boolean getGdbServerDoStart(boolean defaultValue) {

		return Boolean.valueOf(getString(GDB_SERVER_DO_START,
				Boolean.toString(defaultValue)));
	}

	public static void putGdbServerDoStart(boolean value) {

		putWorkspaceString(GDB_SERVER_DO_START, Boolean.toString(value));
	}

	// ----- gdb server executable --------------------------------------------
	public static String getGdbServerExecutable(String defaultValue) {

		return getString(GDB_SERVER_EXECUTABLE, defaultValue);
	}

	public static void putGdbServerExecutable(String value) {

		putWorkspaceString(GDB_SERVER_EXECUTABLE, value);
	}

	// ----- gdb server other options -----------------------------------------
	public static String getGdbServerOtherOptions(String defaultValue) {

		return getString(GDB_SERVER_OTHER_OPTIONS, defaultValue);
	}

	public static void putGdbServerOtherOptions(String value) {

		putWorkspaceString(GDB_SERVER_OTHER_OPTIONS, value);
	}

	// ----- gdb client executable --------------------------------------------
	public static String getGdbClientExecutable(String defaultValue) {

		return getString(GDB_CLIENT_EXECUTABLE, defaultValue);
	}

	public static void putGdbClientExecutable(String value) {

		putWorkspaceString(GDB_CLIENT_EXECUTABLE, value);
	}

	// ----- gdb client other options -----------------------------------------
	public static String getGdbClientOtherOptions(String defaultValue) {

		return getString(GDB_CLIENT_OTHER_OPTIONS, defaultValue);
	}

	public static void putGdbClientOtherOptions(String value) {

		putWorkspaceString(GDB_CLIENT_OTHER_OPTIONS, value);
	}

	// ----- gdb client commands ----------------------------------------------
	public static String getGdbClientCommands(String defaultValue) {

		return getString(GDB_CLIENT_COMMANDS, defaultValue);
	}

	public static void putGdbClientCommands(String value) {

		putWorkspaceString(GDB_CLIENT_COMMANDS, value);
	}

	// ----- QEMU do initial reset -----------------------------------------
	public static boolean getQemuDoInitialReset(boolean defaultValue) {

		return Boolean.valueOf(getString(GDB_QEMU_DO_INITIAL_RESET,
				Boolean.toString(defaultValue)));
	}

	public static void putQemuDoInitialReset(boolean value) {

		putWorkspaceString(GDB_QEMU_DO_INITIAL_RESET, Boolean.toString(value));
	}

	// ----- QEMU enable semihosting ---------------------------------------
	public static boolean getQemuEnableSemihosting(boolean defaultValue) {

		return Boolean.valueOf(getString(GDB_QEMU_ENABLE_SEMIHOSTING,
				Boolean.toString(defaultValue)));
	}

	public static void putQemuEnableSemihosting(boolean value) {

		putWorkspaceString(GDB_QEMU_ENABLE_SEMIHOSTING, Boolean.toString(value));
	}

	// ----- QEMU init other -----------------------------------------------
	public static String getQemuInitOther(String defaultValue) {

		return getString(GDB_QEMU_INIT_OTHER, defaultValue);
	}

	public static void putQemuInitOther(String value) {

		putWorkspaceString(GDB_QEMU_INIT_OTHER, value);
	}

	// ----- QEMU machine name ------------------------------------------------
	public static String getQemuMachineName(String defaultValue) {

		return getString(GDB_QEMU_MACHINE_NAME, defaultValue);
	}

	public static void putQemuMachineName(String value) {

		putWorkspaceString(GDB_QEMU_MACHINE_NAME, value);
	}

	// ----- QEMU debug in ram ---------------------------------------------
	public static boolean getQemuDebugInRam(boolean defaultValue) {

		return Boolean.valueOf(getString(GDB_QEMU_DO_DEBUG_IN_RAM,
				Boolean.toString(defaultValue)));
	}

	public static void putQemuDebugInRam(boolean value) {

		putWorkspaceString(GDB_QEMU_DO_DEBUG_IN_RAM, Boolean.toString(value));
	}

	// ----- QEMU do prerun reset ------------------------------------------
	public static boolean getQemuDoPreRunReset(boolean defaultValue) {

		return Boolean.valueOf(getString(GDB_QEMU_DO_PRERUN_RESET,
				Boolean.toString(defaultValue)));
	}

	public static void putQemuDoPreRunReset(boolean value) {

		putWorkspaceString(GDB_QEMU_DO_PRERUN_RESET, Boolean.toString(value));
	}

	// ----- QEMU init other --------------------------------------------------
	public static String getQemuPreRunOther(String defaultValue) {

		return getString(GDB_QEMU_PRERUN_OTHER, defaultValue);
	}

	public static void putQemuPreRunOther(String value) {

		putWorkspaceString(GDB_QEMU_PRERUN_OTHER, value);
	}

	// ------------------------------------------------------------------------
}
