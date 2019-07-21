package testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({RegexCheckerFilesTest.class,RegexCheckerPatternsTest.class})

public class AllTests {}