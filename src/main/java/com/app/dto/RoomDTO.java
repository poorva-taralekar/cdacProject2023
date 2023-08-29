package com.app.dto;

import com.app.entities.RoomType;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO 
{
   private Long roomid;
   private int status;
   private RoomType type;
   private int price;
}