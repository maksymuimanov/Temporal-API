import PixelBlast from "@/components/PixelBlast.tsx";

export const HeadingBackground = () => {
    return (
        <div className="h-200 w-full absolute inset-0">
            <PixelBlast
                variant="square"
                pixelSize={10}
                color="#B19EEF"
                patternScale={5}
                patternDensity={0.3}
                pixelSizeJitter={1}
                speed={0.2}
                edgeFade={0.33}
                transparent
            />
        </div>
    );
};