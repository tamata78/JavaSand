package file;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVWriter;

public class OpencsvSand {

	public static void main(String[] args) throws IOException {
		String values[] = { "\"", ",", "aaaa", "bbb" };

		// 配列からTSVを作成
		CSVParser csvParser = new CSVParserBuilder().withSeparator('\t').build();
		String line = csvParser.parseToLine(values, true);
		System.out.println(line);

		// 標準出力に出力
		CSVWriter writer = new CSVWriter(new PrintWriter(System.out));
		writer.writeNext(values);
		writer.flush();
		writer.close();

		// 区切り時文字、囲み文字、デフォルトエスケープ文字、改行文字の指定をしつつCSV形式で
		OutputStreamWriter outWriter2 = new OutputStreamWriter(System.out, StandardCharsets.UTF_8);
		CSVWriter csvWriter = new CSVWriter(outWriter2, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER,
				CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
		csvWriter.writeNext(values);
		csvWriter.flush();
		csvWriter.close();

	}

}
