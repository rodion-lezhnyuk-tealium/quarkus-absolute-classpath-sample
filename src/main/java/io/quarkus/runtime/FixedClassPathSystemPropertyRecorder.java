package io.quarkus.runtime;

import java.util.List;

import io.quarkus.runtime.annotations.Recorder;
import jakarta.enterprise.inject.Alternative;

@Alternative
@Recorder
public class FixedClassPathSystemPropertyRecorder {
	public void set(List<String> allJarPaths) {
		System.setProperty("java.class.path", String.join(":", allJarPaths));
	}
}
