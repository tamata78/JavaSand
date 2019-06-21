package jp.grv.sandbox.batch;

import java.io.IOException;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;

public class OpencsvSandbox {

	public static void main(String[] args) throws IOException {
		String values[] = { "\"", ",", "aaaa", "bbb" };

		CSVParser csvParser = new CSVParserBuilder().withSeparator('\t').build();
		String line = csvParser.parseToLine(values, true);

		System.out.println(line);

//        CSVWriter writer = new CSVWriter(new PrintWriter(System.out));
//        writer.writeNext(values);
//        writer.flush();

//        OutputStreamWriter writer = new OutputStreamWriter(out, StandardCharsets.UTF_8);
//        CSVWriter csvWriter = new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR,
//        CSVWriter.NO_QUOTE_CHARACTER,
//        CSVWriter.DEFAULT_ESCAPE_CHARACTER,
//        CSVWriter.DEFAULT_LINE_END);

	}

}
