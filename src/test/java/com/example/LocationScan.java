package com.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

@Setter
@Getter
@ToString
public class LocationScan {

    private String visitRef;
    private String locationRef;
    private String scanTimestamp;

    public LocationScan(String visitRef, String locationRef, String scanTimestamp) {
        this.visitRef = visitRef;
        this.locationRef = locationRef;
        this.scanTimestamp = scanTimestamp;
    }

    public static List<Optional<LocationScan>> getLatestScan(List<LocationScan> scans) {
        return new ArrayList<>(scans.stream()
                .collect(
                        Collectors.groupingBy((lc) -> lc.getVisitRef() + ">>" + lc.getLocationRef(),
                                Collectors.maxBy(Comparator.comparing(LocationScan::getScanTimestamp, Comparator.nullsFirst(Comparator.naturalOrder()))
                                )
                        )
                ).values());
    }

    public static void main(String[] args) {
        List<LocationScan> scans = new ArrayList<>();
        scans.add(new LocationScan("d332da7f-b18b-41b5-9c3b-199068dfaf72", "11125959", "2021-08-18 09:56:05.135"));
        scans.add(new LocationScan("d332da7f-b18b-41b5-9c3b-199068dfaf72", "11125959", "2021-08-18 09:57:05.135"));
        scans.add(new LocationScan("d332da7f-b18b-41b5-9c3b-199068dfaf72", "11125959", ""));
        scans.add(new LocationScan("d332da7f-b18b-41b5-9c3b-199068dfaf73", "11125960", "2023-01-01"));
        scans.add(new LocationScan("d332da7f-b18b-41b5-9c3b-199068dfaf73", "11125960", "2023-01-02"));
        scans.add(new LocationScan("d332da7f-b18b-41b5-9c3b-199068dfaf74", "11125961", null));
        scans.add(new LocationScan("d332da7f-b18b-41b5-9c3b-199068dfaf74", "11125961", null));

        List<Optional<LocationScan>> latestScan = getLatestScan(scans);
        latestScan.forEach(item -> {
            System.out.println(item.orElse(null));
        });
    }
}
