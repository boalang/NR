package boa.dsi.dsource;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.aol.cyclops.data.async.Queue;
import com.google.protobuf.GeneratedMessage;

import boa.datagen.util.CandoiaProperties;
import boa.datagen.util.FileIO;
import boa.dsi.DSComponent;

/**
 * Created by nmtiwari on 11/2/16.
 */
public abstract class AbstractSource implements DSComponent, ProtobufParserI{
	protected ArrayList<String> sources;

	public AbstractSource(ArrayList<String> source) {
		this.sources = source;
	}

	public static final AbstractSource getDataReaders(String source) throws UnsupportedOperationException {
		File settingFile = new File(System.getProperty("user.dir") + "/" + CandoiaProperties.SETTINGS_JSON_FILE_PATH
				+ CandoiaProperties.SETTINGS_JSON_FILE_NAME);
		String setting = FileIO.readFileContents(settingFile);
		JSONArray settings = new JSONArray(setting);
		JSONObject readersList = settings.getJSONObject(CandoiaProperties.DATAREADER_FIELD_INDEX_JSON);
		String[] names = readersList.getString(CandoiaProperties.DATAREADER_FIELD_IN_JSON).split(",");

		for (String name : names) {
			try {
				@SuppressWarnings("unchecked")
				Class<AbstractSource> clas = (Class<AbstractSource>) Class.forName(name);
				AbstractSource reader = clas.getConstructor(String.class).newInstance(source);
				if (reader.isReadable(source)) {
					return reader;
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		throw new UnsupportedOperationException();
	}

	public abstract boolean isReadable(String source);

	public abstract List<GeneratedMessage> getData();

	public abstract String getParserClassName();

	public boolean getDataInQueue(Queue<GeneratedMessage> queue) {
		if (queue == null || !queue.isOpen()) {
			throw new IllegalStateException("Your queue is not yet initialized");
		}
		// getData().forEach(data -> queue.offer(data));
		for (GeneratedMessage message : getData()) {
			queue.offer(message);
		}
		queue.close();
		return true;
	}
}
