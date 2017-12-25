CREATE TABLE `learn-statistic` (
  request           VARCHAR(255) NOT NULL,
  code              INT          NOT NULL,
  size              INT          NOT NULL,
  `html_tags_count` INT          NOT NULL,
  latency           INT          NOT NULL
);


CREATE TABLE `response-code-distribution` (
  request     VARCHAR(255) NOT NULL,
  value       INT          NOT NULL,
  probability DOUBLE       NOT NULL
);


CREATE TABLE `response-size-distribution` (
  request          VARCHAR(255) NOT NULL,
  math_expectation DOUBLE       NOT NULL,
  variance         DOUBLE       NOT NULL
);

CREATE TABLE `keywords-count-distribution` (
  request          VARCHAR(255) NOT NULL,
  math_expectation DOUBLE       NOT NULL,
  variance         DOUBLE       NOT NULL
);

CREATE TABLE `latency-distribution` (
  request          VARCHAR(255) NOT NULL,
  math_expectation DOUBLE       NOT NULL,
  variance         DOUBLE       NOT NULL
);