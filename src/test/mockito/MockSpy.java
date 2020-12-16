package test.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mock;

import test.mockito.bean.Foo;
import test.mockito.bean.Hoge;

public class MockSpy {
	@Mock
	private Hoge hoge;

	@Mock
	private Foo foo;

	@Test
	public static void mockTest() {
		// クラス実装に依存しないモックオブジェクトを作る
		Hoge hoge = mock(Hoge.class);
		Foo foo = new Foo();
		when(hoge.getFoo()).thenReturn(foo);
		assertThat(hoge.getFoo(), is(foo));
	}

}
