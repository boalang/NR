package boa.bio.datagen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import com.aol.cyclops.data.async.Queue;
import com.google.protobuf.GeneratedMessage;

import boa.dsi.dsource.bio.Genomics;
import boa.dsi.dsource.fars.FARS;
import boa.dsi.evaluator.EvaluationEngine;
//ssimport boa.dsi.storage.sequencefile.NRFileStorage;
import boa.dsi.storage.sequencefile.SequenceFileStorage;

public class JSONGen {

	public static void main(String[] args) {

		String output = args[0]; // where should the output go
		String rawPath = args[1];

		ArrayList<String> sources = new ArrayList<String>();

		sources.clear();
		sources.add(rawPath);
		Genomics external = new Genomics(sources);

		// external : Which AbstractDataSource to use to parse the data
		SequenceFileStorage storage = new SequenceFileStorage(output, external);

		storage.store_json(rawPath);

	}
}
