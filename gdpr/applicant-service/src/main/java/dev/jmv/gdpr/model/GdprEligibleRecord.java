package dev.jmv.gdpr.model;

import java.util.List;

public record GdprEligibleRecord(List<Long> applicantIds, List<Long> applicantEventIds) {
}
