package com.hk;

import springfox.documentation.oas.annotations.EnableOpenApi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableOpenApi
@ComponentScan(basePackages = { "com.hk", "com.hk.api", "com.hk.configuration" })
public class MainApplication implements CommandLineRunner {

	public static void main(String[] args) throws Exception {
		new SpringApplication(MainApplication.class).run(args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		if (arg0.length > 0 && arg0[0].equals("exitcode")) {
			throw new ExitException();
		}
	}

	class ExitException extends RuntimeException implements ExitCodeGenerator {
		private static final long serialVersionUID = 1L;

		@Override
		public int getExitCode() {
			return 10;
		}

	}
}
